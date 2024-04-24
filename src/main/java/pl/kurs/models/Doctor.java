package pl.kurs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Doctor implements Serializable {
    static final long serialVersionUID = 42L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idFormTxt;
    private String lastName;
    private String firstName;
    private String specialty;
    private LocalDate dateOfBirth;
    private String nip;
    private String pesel;


    public Doctor() {
    }

    public Doctor(Long id, String lastName, String firstName, String specialty, LocalDate dateOfBirth, String nip, String pesel) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.specialty = specialty;
        this.dateOfBirth = dateOfBirth;
        this.nip = nip;
        this.pesel = pesel;
    }



    public void setIdFormTxt(Long idFormTxt) {
        this.idFormTxt = idFormTxt;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Long getIdFormTxt() {
        return idFormTxt;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNip() {
        return nip;
    }

    public String getPesel() {
        return pesel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) && Objects.equals(idFormTxt, doctor.idFormTxt) && Objects.equals(lastName, doctor.lastName) && Objects.equals(firstName, doctor.firstName) && Objects.equals(specialty, doctor.specialty) && Objects.equals(dateOfBirth, doctor.dateOfBirth) && Objects.equals(nip, doctor.nip) && Objects.equals(pesel, doctor.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idFormTxt, lastName, firstName, specialty, dateOfBirth, nip, pesel);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idFormTxt=" + idFormTxt +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nip='" + nip + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
