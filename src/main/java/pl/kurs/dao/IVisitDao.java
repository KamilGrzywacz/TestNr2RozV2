package pl.kurs.dao;

import pl.kurs.models.Visit;

import java.util.List;

public interface IVisitDao {
    void save(Visit visit);

    Visit get(Long id);

    List<Visit> findAllVisits(Long patientIdFromTxT);


}
