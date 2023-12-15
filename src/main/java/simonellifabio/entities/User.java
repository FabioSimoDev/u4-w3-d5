package simonellifabio.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utente")
public class User {

    @Id
    @GeneratedValue
    private long ID;

    String firstName;
    String lastName;

    private LocalDate birthDate;

    private UUID cardNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Loan> loanList;

    public User() {
    }

    public User(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.cardNumber = UUID.randomUUID();
    }

    public long getID() {
        return ID;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public UUID getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(UUID cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }

    public void addLoan(Loan loan){
        if(loanList != null){
            loanList.add(loan);
        }else{
            loanList = new ArrayList<>();
            loanList.add(loan);
        }
    }
}
