package main.domain.user.profile;

/**
 * Created by Joel on 11.06.2017.
 */

import main.domain.user.contact.Contact;
import main.domain.user.stats.PlayedChamps;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HeadUpProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int bnt;
    private String username;

    private int compRank;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    private PlayedChamps playedChamps;

    private String profileImgUrl;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "hup_playTime",
            joinColumns = @JoinColumn(name = "hup_id"),
            inverseJoinColumns = @JoinColumn(name = "playTime_id")
    )
    private List<TimeSpan> usualPlayTime;


    public HeadUpProfile() {
        this.setUsername("").setBnt(0).setContact(new Contact()).setPlayedChamps(new PlayedChamps()).setUsualPlayTime(new ArrayList<>());
    }


    public int getCompRank() {
        return compRank;
    }

    public HeadUpProfile setCompRank(int compRank) {
        this.compRank = compRank;
        return this;
    }


    public int getBnt() {
        return bnt;
    }

    public HeadUpProfile setBnt(int bnt) {
        this.bnt = bnt;
        return this;
    }

    public List<TimeSpan> getUsualPlayTime() {
        return usualPlayTime;
    }

    public HeadUpProfile setUsualPlayTime(List<TimeSpan> usualPlayTime) {
        this.usualPlayTime = usualPlayTime;
        return this;
    }

    public HeadUpProfile addUsualPlayTime(TimeSpan timeSpan) {
        if (this.usualPlayTime == null) {
            this.usualPlayTime = new ArrayList<>();
        }
        this.usualPlayTime.add(timeSpan);
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

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public HeadUpProfile setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
        return this;
    }

}
