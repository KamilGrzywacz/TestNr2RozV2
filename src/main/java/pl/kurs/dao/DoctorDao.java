package pl.kurs.dao;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import pl.kurs.models.Doctor;

import java.util.Optional;

@Repository
public class DoctorDao implements IDoctorDao {

    @PersistenceUnit
    private EntityManagerFactory factory;

    public DoctorDao() {
    }

    @Override
    public void save(Doctor doctor) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(doctor);
        tx.commit();
        entityManager.close();

    }

    @Override
    public Doctor get(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            return entityManager.find(Doctor.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<Doctor> findByIdFormTxt(Long idFromTxt) {
        EntityManager entityManager = factory.createEntityManager();
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Doctor> query = criteriaBuilder.createQuery(Doctor.class);
            Root<Doctor> root = query.from(Doctor.class);
            query.select(root).where(criteriaBuilder.equal(root.get("idFormTxt"), idFromTxt));

            Doctor doctor = entityManager.createQuery(query).getSingleResult();

            return Optional.ofNullable(doctor);
        } catch (NoResultException e) {
            return Optional.empty();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        Doctor doctor = entityManager.find(Doctor.class, id);
        return Optional.ofNullable(doctor);
    }

}

