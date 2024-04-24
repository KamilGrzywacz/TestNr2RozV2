package pl.kurs.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.kurs.dao.IDoctorDao;
import pl.kurs.dao.IPatientDao;
import pl.kurs.dao.IVisitDao;
import pl.kurs.models.Doctor;
import pl.kurs.models.Patient;
import pl.kurs.models.Visit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class DataImporter {

    private IDoctorDao doctorDao;
    private IPatientDao patientDao;
    private IVisitDao visitDao;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

    private String doctorsFilePath;

    private String patientsFilePath;

    private String visitsFilePath;

    public DataImporter() {
    }

    @Autowired
    public DataImporter(IDoctorDao doctorDao, IPatientDao patientDao, IVisitDao visitDao, Environment environment) {
        this.doctorDao = doctorDao;
        this.patientDao = patientDao;
        this.visitDao = visitDao;
        this.doctorsFilePath = environment.getProperty("file.path.doctors");
        this.patientsFilePath = environment.getProperty("file.path.patients");
        this.visitsFilePath = environment.getProperty("file.path.visits");
    }


    @Transactional
    @Value("${file.path.doctors}")
    public void readAndSaveDoctorsFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(doctorsFilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 7) {
                    Doctor doctor = new Doctor();
                    doctor.setIdFormTxt(Long.parseLong(parts[0]));
                    doctor.setLastName(parts[1]);
                    doctor.setFirstName(parts[2]);
                    doctor.setSpecialty(parts[3]);
                    doctor.setDateOfBirth(LocalDate.parse(parts[4]));
                    doctor.setNip(parts[5]);
                    doctor.setPesel(parts[6]);
                    doctorDao.save(doctor);
                } else {
                    System.out.println("Błąd w formacie linii: " + line);
                }
            }
        }
    }


    @Transactional
    @Value("${file.path.patients}")
    public void readAndSavePatientsFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(patientsFilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 5) {
                    Patient patient = new Patient();
                    patient.setIdFormTxt(Long.parseLong(parts[0]));
                    patient.setLastName(parts[1]);
                    patient.setFirstName(parts[2]);
                    patient.setPesel(parts[3]);
                    patient.setDateOfBirth(LocalDate.parse(parts[4], formatter));
                    patientDao.save(patient);
                } else {
                    System.out.println("Błąd w formacie linii: " + line);
                }
            }
        }
    }


    @Transactional
    @Value("${file.path.visits}")
    public void readAndSaveVisitsFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(visitsFilePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    Long doctorId = Long.parseLong(parts[0]);
                    Long patientId = Long.parseLong(parts[1]);
                    LocalDate dateOfVisit = LocalDate.parse(parts[2], formatter);
                    Visit visit = new Visit();
                    visit.setIdDoctor(doctorId);
                    visit.setIdPatient(patientId);
                    visit.setDateOfVisit(dateOfVisit);

                    visitDao.save(visit);
                } else {
                    System.out.println("Error in line format: " + line);
                }
            }
        }
    }
}



