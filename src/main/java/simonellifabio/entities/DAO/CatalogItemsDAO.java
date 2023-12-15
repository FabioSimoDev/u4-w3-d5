package simonellifabio.entities.DAO;

import simonellifabio.entities.CatalogItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<CatalogItem> findByISBN(String ISBN){
        TypedQuery<CatalogItem> query = em.createNamedQuery("findByISBN", CatalogItem.class);
        query.setParameter("isbn", ISBN);
        return query.getResultList();
    }

    public List<CatalogItem> findByPublishingYear(int year){
        TypedQuery<CatalogItem> query = em.createNamedQuery("findByPublishingYear", CatalogItem.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<CatalogItem> findByTitle(String title){
        TypedQuery<CatalogItem> query = em.createNamedQuery("findByTitle", CatalogItem.class);
        query.setParameter("titlePart", title);
        return query.getResultList();
    }

    public List<CatalogItem> findByAuthor(String author){
        TypedQuery<CatalogItem> query = em.createNamedQuery("findByAuthor", CatalogItem.class);
        query.setParameter("author", author.toLowerCase());
        return query.getResultList();
    }
}
