package simonellifabio.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "catalog_item")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "findByISBN", query = "SELECT c FROM CatalogItem c WHERE c.ISBN = :isbn")
@NamedQuery(name = "findByPublishingYear", query = "SELECT c FROM CatalogItem c WHERE c.publicationYear = :year")
@NamedQuery(name = "findByTitle", query = "SELECT c FROM CatalogItem c WHERE c.title LIKE :titlePart")
//@NamedQuery(name = "findByCardNumber", query = "SELECT l FROM Loan l WHERE l.user.cardNumber = :cardNumber AND l.actualReturnDate IS NULL")
//@NamedQuery(name = "findByExpiredLoan", query = "SELECT l FROM Loan l WHERE l.expectedReturnDate < :today AND l.actualReturnDate IS NULL")
//non ho avuto tempo per implementare queste due query
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

    @OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST)
    private List<Loan> loanList;

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

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void addLoan(Loan loan){
        if(loanList != null){
            loanList.add(loan);
        }else{
            loanList = new ArrayList<>();
            loanList.add(loan);
        }
    }

    @Override
    public String toString() {
        return "CatalogItem{" +
                "ISBN='" + ISBN + '\'' +
                ", ID=" + ID +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pageCount=" + pageCount +
                ", loanList=" + loanList +
                '}';
    }
}
