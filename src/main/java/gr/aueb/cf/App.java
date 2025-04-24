package gr.aueb.cf;

import gr.aueb.cf.core.enums.GenderType;
import gr.aueb.cf.model.Region;
import gr.aueb.cf.model.Teacher;
import gr.aueb.cf.model.TeacherMoreInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

/**
 * Hello world!
 */
public class App {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("school7PU");
    private final static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

        em.getTransaction().begin();

        Teacher teacher = Teacher.builder()
                        .firstname("Κώστας")
                        .lastname("Γιαννούτσος")
                        .isActive(true)
                        .build();

        TeacherMoreInfo teacherMoreInfo = TeacherMoreInfo.builder()
                        .dateOfBirth(LocalDateTime.of(2000, 2, 1, 10, 10, 10))
                        .gender(GenderType.MALE)
                        .build();

        teacher.setTeacherMoreInfo(teacherMoreInfo);
        Region region = em.find(Region.class, 1);
        teacher.addRegion(region);

        em.persist(teacher);
        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}
