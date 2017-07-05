package main.persistence.chat;

import main.domain.chat.Chat;
import main.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Joel on 04.07.2017.
 */
@Repository
public interface ChatRepository extends CrudRepository<Chat, Integer> {

    List<Chat> findAllByParticipantsContaining(User user);

}
