package main.persistence.chat;

import main.domain.chat.GameRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joel on 04.07.2017.
 */
@Repository
public interface GameRequestRepository extends CrudRepository<GameRequest, Integer> {
}
