package pl.kurs.dao;

import pl.kurs.models.Doctor;

import java.util.Optional;

public interface IDoctorDao {
    void save(Doctor doctor);
    Doctor get(Long id);
    Optional<Doctor> findByIdFormTxt(Long idFromTxt);

    Optional<Doctor> findById(Long id);
}
