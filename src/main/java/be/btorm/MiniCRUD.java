package be.btorm;

import be.btorm.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class MiniCRUD {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private static final EntityManager em = emf.createEntityManager();


    public static void add(User user){

        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();

        System.out.println("Ajout de : " + user);
    }

    public static Optional<User> getOne(Long id){

        User user = em.find(User.class,id);
        System.out.println("Recuperation de : " + user);
        return Optional.ofNullable(user);
    }

    public static List<User> getAll(){

        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();
        System.out.println("Resultat(s) reçut : ");
        users.forEach(System.out::println);
        em.clear();
        return users;
    }

    public static void update(User user){

        em.getTransaction().begin();

        em.merge(user);
        System.out.println("Modification de : " + user);
        em.getTransaction().commit();
    }

    public static void delete(Long id){

        em.getTransaction().begin();

//        Optional<User> user = getOne(id);
//        if(user.isPresent())
//            em.remove(user.get());

        User user = getOne(id).orElseThrow();
        em.remove(user);

        em.getTransaction().commit();
    }

    public static void delete(User user){

        em.getTransaction().begin();

        em.remove(em.merge(user));

        em.getTransaction().commit();

        System.out.println("Suppression de : " + user);
    }
}
