package main.domain.user.profile;

import main.domain.registration.Registration;
import main.domain.user.userScore.UserScore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 11.06.2017.
 */
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    private List<Integer> chatIds;
    private boolean smurf;
    private boolean premium;

    private String biography;
    @OneToOne(cascade=CascadeType.ALL)
    private UserScore userScore;

    @OneToOne(cascade=CascadeType.ALL)
    private HeadUpProfile headUpProfile;

    public Profile() {
    }

    public Profile(Registration registration) {
        this.headUpProfile = new HeadUpProfile().setBnt(registration.getBnt()).setUsername(registration.getUsername());
        this.smurf = false;
        this.premium = false;
        this.biography = "";
        this.userScore = new UserScore().setFriendly(10).setOnTime(10);
        this.chatIds = new ArrayList<>();
    }

    public void setChatIds(List<Integer> chatIds) {
        this.chatIds = chatIds;
    }

//    public void addChatId

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Integer> getChatIds() {
        return chatIds;
    }

    public String getBiography() {
        return biography;
    }

    public boolean isSmurf() {
        return smurf;
    }

    public void setSmurf(boolean smurf) {
        this.smurf = smurf;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }


    public UserScore getUserScore() {
        return userScore;
    }

    public void setUserScore(UserScore userScore) {
        this.userScore = userScore;
    }

    public HeadUpProfile getHeadUpProfile() {
        return headUpProfile;
    }

    public void setHeadUpProfile(HeadUpProfile headUpProfile) {
        this.headUpProfile = headUpProfile;
    }


}
