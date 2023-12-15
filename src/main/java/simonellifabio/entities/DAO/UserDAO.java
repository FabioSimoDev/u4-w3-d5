package simonellifabio.entities.DAO;

import simonellifabio.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em){
        this.em = em;
    }

    public void save(User item){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(item);

        transaction.commit();

        System.out.println("user salvato nel database.");
    }
}
