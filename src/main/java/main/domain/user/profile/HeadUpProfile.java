package main.domain.user.profile;

/**
 * Created by Joel on 11.06.2017.
 */

import main.domain.user.contact.Contact;
import main.domain.user.stats.PlayedChamps;

import javax.persistence.*;

@Entity
public class HeadUpProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int bnt;
    private String username;

    @OneToOne(cascade=CascadeType.ALL)
    private Contact contact;

    @OneToOne(cascade=CascadeType.ALL)
    private PlayedChamps playedChamps;


    public HeadUpProfile() {
        this.setUsername("").setBnt(0000).setContact(new Contact()).setPlayedChamps(new PlayedChamps());
    }

    public int getBnt() {
        return bnt;
    }

    public HeadUpProfile setBnt(int bnt) {
        this.bnt = bnt;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public HeadUpProfile setUsername(String username) {
        this.username = username;
        return this;
    }

    public Contact getContact() {
        return contact;
    }

    public HeadUpProfile setContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    public PlayedChamps getPlayedChamps() {
        return playedChamps;
    }

    public HeadUpProfile setPlayedChamps(PlayedChamps playedChamps) {
        this.playedChamps = playedChamps;
        return this;
    }
}
