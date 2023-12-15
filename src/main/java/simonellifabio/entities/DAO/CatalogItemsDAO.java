package simonellifabio.entities.DAO;

import simonellifabio.entities.CatalogItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CatalogItemsDAO {
    private final EntityManager em;

    public CatalogItemsDAO(EntityManager em){
        this.em = em;
    }

    public void save(CatalogItem item){
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(item);

        transaction.commit();

        System.out.println("item salvato nel database.");
    }


    public CatalogItem getById(long id){
        return em.find(CatalogItem.class, id);
    }

    public void delete(long id){
        CatalogItem found = this.getById(id);

        if(found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("item rimosso dal database");
        }else{
            System.out.println("item non trovato, sicuro che l'id sia corretto?");
        }
    }
}
