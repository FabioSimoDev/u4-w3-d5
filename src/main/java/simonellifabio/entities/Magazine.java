package simonellifabio.entities;

import simonellifabio.entities.enums.magazine.Periodicity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "rivista")
public class Magazine extends CatalogItem{
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazine() {
    }

    public Magazine(String isbn, String title, int publicationYear, int pageCount, Periodicity periodicity) {
        super(isbn, title, publicationYear, pageCount);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }
}
