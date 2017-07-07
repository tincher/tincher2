package main.domain.chat;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Joel on 04.07.2017.
 */
@Entity
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private DateTime time;

    private String content;


    public ChatMessage() {
    }

    public DateTime getTime() {
        return time;
    }

    public ChatMessage setTime(DateTime time) {
        this.time = time;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ChatMessage setContent(String content) {
        this.content = content;
        return this;
    }

}
