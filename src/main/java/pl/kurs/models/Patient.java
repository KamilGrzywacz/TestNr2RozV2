package pl.kurs.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Patient implements Serializable {
    static final long serialVersionUID = 42L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idFormTxt;
    private String lastName;
    private String firstName;
    private String pesel;
    private LocalDate dateOfBirth;

    @Transient
    List<Visit> visits = new ArrayList();


    public Patient() {
    }


    public Patient(Long idFormTxt, String lastName, String firstName, String pesel, LocalDate dateOfBirth, List<Visit> visits) {
        this.idFormTxt = idFormTxt;
        this.lastName = lastName;
        this.firstName = firstName;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
        this.visits = visits;
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public Long getIdFormTxt() {
        return idFormTxt;
    }

    public void setIdFormTxt(Long idFormTxt) {
        this.idFormTxt = idFormTxt;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && Objects.equals(idFormTxt, patient.idFormTxt) && Objects.equals(lastName, patient.lastName) && Objects.equals(firstName, patient.firstName) && Objects.equals(pesel, patient.pesel) && Objects.equals(dateOfBirth, patient.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idFormTxt, lastName, firstName, pesel, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idFormTxt=" + idFormTxt +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public Patient getId(Patient patient) {
        return patient.getId(patient) ;

    }
}
