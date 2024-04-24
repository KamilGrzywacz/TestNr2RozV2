package pl.kurs.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Visit implements Serializable {
    static final long serialVersionUID = 42L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Doctor doctor;

    @Transient
    private Patient patient;

    private Long idDoctor;

    private Long idPatient;

    private LocalDate dateOfVisit;

    public Visit() {
    }

    public Visit(Doctor doctor, Patient patient, LocalDate dateOfVisit) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateOfVisit = dateOfVisit;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id) && Objects.equals(doctor, visit.doctor) && Objects.equals(patient, visit.patient) && Objects.equals(dateOfVisit, visit.dateOfVisit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, patient, dateOfVisit);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", idDoctor=" + idDoctor +
                ", idPatient=" + idPatient +
                ", dateOfVisit=" + dateOfVisit +
                '}';
    }
}


