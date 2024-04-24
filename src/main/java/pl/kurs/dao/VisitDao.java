package pl.kurs.dao;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import pl.kurs.models.Visit;

import java.util.List;

@Repository
public class VisitDao implements IVisitDao {

    @PersistenceUnit
    private EntityManagerFactory factory;

    public VisitDao() {
    }

    @Override
    public void save(Visit visit) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(visit);
        tx.commit();
        entityManager.close();
    }


    @Override
    public Visit get(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        Visit visit = entityManager.find(Visit.class, id);
        entityManager.close();
        return visit;
    }

    @Override
    public List<Visit> findAllVisits(Long idPatient) {
        EntityManager entityManager = factory.createEntityManager();
    return entityManager.createNativeQuery(
                    "SELECT * FROM visit WHERE idPatient = :idPatient", Visit.class)
            .setParameter("idPatient", idPatient)
            .getResultList();
}

}
