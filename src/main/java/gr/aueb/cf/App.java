package gr.aueb.cf;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("school7PU");
    private final static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {




        em.close();
        emf.close();
    }
}
