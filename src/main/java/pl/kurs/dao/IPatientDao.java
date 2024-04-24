package pl.kurs.dao;

import pl.kurs.models.Patient;

import java.util.Optional;

public interface IPatientDao {
    void save(Patient patient);
    Patient get(Long id);
    Optional<Patient> findByIdFormTxt(Long idFromTxt);

    Optional<Patient> findById(Long patientId);

}
