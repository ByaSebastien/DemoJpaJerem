package be.btorm;

import be.btorm.entities.Mayor;
import be.btorm.entities.Municipality;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OneToOneDemo {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private final EntityManager em = emf.createEntityManager();


    public void add(){

        Municipality municipality = Municipality.builder()
                .name("Fexhe le Haut Clocher")
                .build();
        Mayor mayor = Mayor.builder()
                .name("Henri Christophe")
                .build();

        municipality.setMayor(mayor);

        em.getTransaction().begin();

        em.persist(municipality);

        em.getTransaction().commit();
    }

    public Municipality get(){


        em.getTransaction().begin();

        Municipality municipality = em.find(Municipality.class,1L);
        em.getTransaction().commit();
        return municipality;

//        System.out.println(municipality);
//        System.out.println(municipality.getMayor());
    }
}
