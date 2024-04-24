package pl.kurs.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pl.kurs.dao.IDoctorDao;
import pl.kurs.dao.IPatientDao;
import pl.kurs.dao.IVisitDao;
import pl.kurs.models.Visit;

import java.io.IOException;
import java.util.List;

@ComponentScan(basePackages = "pl.kurs")
public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        IDoctorDao doctorDao = ctx.getBean(IDoctorDao.class);
        IPatientDao patientDao = ctx.getBean(IPatientDao.class);
        IVisitDao visitDao = ctx.getBean(IVisitDao.class);

        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("doctorDao.findByIdFormTxt(23l) = " + doctorDao.findByIdFormTxt(23l));
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Lista wizyt dla pacjenta z numerem ID 100 to := " + visitDao.findAllVisits(100l));
        System.out.println("-----------------------------------------------------------------------------------------------");





    }


}
