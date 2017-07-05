package main.domain.chat;

import main.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 04.07.2017.
 */
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "chat_cmessages",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "cmessage_id")
    )
    private List<Chat> chats;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "chat_participants",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> participants;


    public List<Chat> getChats() {
        return chats;
    }

    public Chat setChats(List<Chat> chats) {
        this.chats = chats;
        return this;
    }

    public Chat addChat(Chat chat) {
        if (this.chats == null) {
            this.chats = new ArrayList<>();
        }
        this.chats.add(chat);
        return this;
    }
}
