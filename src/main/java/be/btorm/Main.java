package be.btorm;

import be.btorm.entities.Address;
import be.btorm.entities.GenderType;
import be.btorm.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        User user = User.builder()
                .firstName("Jerem")
                .lastName("Bazin")
                .birthDate(LocalDate.now())
                .gender(GenderType.MALE)
                .address(new Address("coucou", "les zouloux"))
                .friends(List.of("Pierre","Pol","Jacque"))
                .build();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.detach(user);
        user.setFirstName("Coucou");
        em.getTransaction().commit();

    }
}