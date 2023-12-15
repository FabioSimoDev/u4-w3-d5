package simonellifabio.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "prestito")
public class Loan {
    @Id
    @GeneratedValue
    private long ID;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_catalogo_id")
    private CatalogItem item; //sarebbe l'elemento in prestito

    private LocalDate loanDate;

    private LocalDate expectedReturnDate;

    private LocalDate actualReturnDate;

    public Loan() {
    }

    public Loan(User user, CatalogItem item, LocalDate loanDate, LocalDate expectedReturnDate) {
        this.user = user;
        this.item = item;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
    }

    public long getID() {
        return ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CatalogItem getItem() {
        return item;
    }

    public void setItem(CatalogItem item) {
        this.item = item;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
}
