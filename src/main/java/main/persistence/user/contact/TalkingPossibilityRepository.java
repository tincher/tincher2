package main.persistence.user.contact;

import main.domain.user.contact.TalkingPossibility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joel on 11.06.2017.
 */
@Repository
public interface TalkingPossibilityRepository extends CrudRepository<TalkingPossibility, Integer> {
}
