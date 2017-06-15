package main.domain.user.contact;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Joel on 11.06.2017.
 */
@Entity
public class TalkingPossibility {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String talkingPossibility;

    public TalkingPossibility() {
    }

    public String getTalkingPossibility() {
        return talkingPossibility;
    }

    public TalkingPossibility setTalkingPossibility(String talkingPossibility) {
        this.talkingPossibility = talkingPossibility;
        return this;
    }

}
