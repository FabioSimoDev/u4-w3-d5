package simonellifabio.entities;

import java.util.Date;
import java.util.UUID;

public class User {
    String firstName;
    String lastName;

    private Date birthDate;

    private UUID cardNumber;

    public User() {
    }

    public User(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.cardNumber = UUID.randomUUID();
    }
}
