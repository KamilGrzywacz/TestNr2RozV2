package pl.kurs.dao;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import pl.kurs.models.Doctor;
import pl.kurs.models.Patient;

import java.util.Optional;

@Repository
public class PatientDao implements IPatientDao {
    @PersistenceUnit
    private EntityManagerFactory factory;

    public PatientDao() {
    }

    @Override
    public void save(Patient patient) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(patient);
        tx.commit();
        entityManager.close();
    }

    @Override
    public Patient get(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        Patient patient = entityManager.find(Patient.class, id);
        entityManager.close();
        return patient;
    }


    @Override
    public Optional<Patient> findByIdFormTxt(Long idFromTxt) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Patient> query = criteriaBuilder.createQuery(Patient.class);
            Root<Patient> root = query.from(Patient.class);
            query.select(root).where(criteriaBuilder.equal(root.get("idFormTxt"), idFromTxt));

            Patient patient = entityManager.createQuery(query).getSingleResult();

            return Optional.ofNullable(patient);
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<Patient> findById(Long patientId) {
        EntityManager entityManager = factory.createEntityManager();
        Patient patient = entityManager.find(Patient.class, patientId);
        return Optional.ofNullable(patient);
    }
}
