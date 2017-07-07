package main.facade.RESTController;

import main.domain.chat.Chat;
import main.domain.chat.ChatMessage;
import main.domain.user.User;
import main.persistence.chat.ChatRepository;
import main.persistence.chat.GameRequestRepository;
import main.persistence.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Joel on 04.07.2017.
 */
//@RestController("chat")
@Controller
@MessageMapping("chat")
public class ChatController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private GameRequestRepository gameRequestRepository;


    @MessageMapping("/getAllMessages/{userId}")
    public List<Chat> getMessagesForUser(@PathVariable Integer userid) {
        User user = userRepository.findOne(userid);
        return chatRepository.findAllByParticipantsContaining(user);
    }

    @MessageMapping("/sendMessage/{bnt}/{username}")
    @SendTo("/messages/user/{bnt}/{username}")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/sendGameRequest/{bnt}/{username}")
    @SendTo("/gamerequests/user/{bnt}/{username}")
    public ChatMessage sendGameRequest(ChatMessage chatMessage) {
        return chatMessage;
    }


}
