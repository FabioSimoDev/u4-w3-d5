package simonellifabio.entities;

import simonellifabio.entities.enums.magazine.Periodicity;

public class Magazine extends CatalogItem{
    private Periodicity periodicity;

    public Magazine() {
    }

    public Magazine(String isbn, String title, int publicationYear, int pageCount, Periodicity periodicity) {
        super(isbn, title, publicationYear, pageCount);
        this.periodicity = periodicity;
    }
}
