package main.domain.registration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Joel on 11.06.2017.
 */
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date registrationDate;
    private String username;
    private int bnt;


    public Registration() {
        this.registrationDate = new Date();
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

//    public Registration setRegistrationDate(Date registrationDate) {
//        this.registrationDate = registrationDate;
//        return this;
//    }

    public String getUsername() {
        return username;
    }

    public Registration setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getBnt() {
        return bnt;
    }

    public Registration setBnt(int bnt) {
        this.bnt = bnt;
        return this;
    }
}
