package simonellifabio.entities;

import java.util.Date;

public class Loan {
    private User user;
    private CatalogItem item; //sarebbe l'elemento in prestito

    private Date loanDate;

    private Date expectedReturnDate;

    private Date actualReturnDate;

    public Loan() {
    }

    public Loan(User user, CatalogItem item, Date loanDate, Date expectedReturnDate) {
        this.user = user;
        this.item = item;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
    }
}
