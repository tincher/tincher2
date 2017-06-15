package main.domain.user.userScore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Joel on 11.06.2017.
 */
@Entity
public class UserScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int onTime;
    private int friendly;
//    private List<String> guestbook;

    public UserScore() {
    }

    public int getOnTime() {
        return onTime;
    }

    public UserScore setOnTime(int onTime) {
        this.onTime = onTime;
        return this;
    }

    public int getFriendly() {
        return friendly;
    }

    public UserScore setFriendly(int friendly) {
        this.friendly = friendly;
        return this;
    }

//    public List<String> getGuestbook() {
//        return guestbook;
//    }

//    public UserScore setGuestbook(List<String> guestbook) {
//        this.guestbook = guestbook;
//        return this;
//    }
//
//    public UserScore addGuestbook(String guestbook) {
//        this.guestbook.add(guestbook);
//        return this;
//    }
}
