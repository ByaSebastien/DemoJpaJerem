package be.btorm;

import be.btorm.banques.Banque;
import be.btorm.banques.InterfaceFonctionelle;
import be.btorm.entities.Address;
import be.btorm.entities.GenderType;
import be.btorm.entities.Municipality;
import be.btorm.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//#region jpa 1
//        User user = User.builder()
//                .firstName("Jerem")
//                .lastName("Bazin")
//                .birthDate(LocalDate.now())
//                .gender(GenderType.MALE)
//                .address(new Address("coucou", "les zouloux"))
//                .friends(List.of("Pierre","Pol","Jacque"))
//                .build();
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
//
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(user);
//        em.detach(user);
//        user.setFirstName("Coucou");
//        em.getTransaction().commit();
//#endregion

//#region jpa 1
        OneToOneDemo demo1 = new OneToOneDemo();
        demo1.add();
        Municipality m = demo1.get();
        System.out.println(m);

//#endregion


//#region Interface fonctionnelle
//        InterfaceFonctionelle del = new InterfaceFonctionelle() {
//            @Override
//            public void execute() {
//                System.out.println("Alert");
//            }
//        };
//
//        del = () -> alert();
//
//        Banque b = new Banque(100D);
//
//        b.subscribe(() -> System.out.println("Passage en negatif"));
//        b.subscribe(() -> System.out.println("mon coco"));
//        b.subscribe(() -> System.out.println("les delege c'etait bien"));
//
//        b.setSolde(-50D);
//#endregion

    }

    public static void alert() {
        System.out.println("Alert");
    }
}