package main.domain.chat;

import main.domain.user.profile.TimeSpan;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by Joel on 04.07.2017.
 */
@Entity
public class GameRequest extends ChatMessage {

    private boolean accepted;
    @OneToOne
    private TimeSpan timeSpan;


    public GameRequest() {
        super();
    }

    public boolean isAccepted() {
        return accepted;
    }

    public GameRequest setAccepted(boolean accepted) {
        this.accepted = accepted;
        return this;
    }

    public TimeSpan getTimeSpan() {
        return timeSpan;
    }

    public GameRequest setTimeSpan(TimeSpan timeSpan) {
        this.timeSpan = timeSpan;
        return this;
    }
}
