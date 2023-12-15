package simonellifabio.entities;

import javax.persistence.*;

@Entity
@Table(name = "catalog_item")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CatalogItem {
    @Column(nullable = false, unique = true)
    private String ISBN;

    @Id
    @GeneratedValue
    private long ID;

    @Column(nullable = false)
    private String title;

    @Column(name = "anno_pubblicazione")
    private int publicationYear;

    @Column(name = "numero_pagine")
    private int pageCount;

    public CatalogItem() {
    }

    public CatalogItem(String ISBN, String title, int publicationYear, int pageCount) {
        this.ISBN = ISBN;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public long getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
