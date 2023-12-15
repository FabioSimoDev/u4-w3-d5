package simonellifabio.entities.DAO;

import simonellifabio.entities.CatalogItem;
import simonellifabio.entities.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoanDAO {
    private final EntityManager em;

    public LoanDAO(EntityManager em){
        this.em = em;
    }

    public void save(Loan item){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(item);

        transaction.commit();

        System.out.println("prestito salvato nel database.");
    }
}
