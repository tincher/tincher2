package main.persistence.user.userScore;

import main.domain.user.userScore.UserScore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joel on 28.06.2017.
 */
@Repository
public interface UserScoreRepository extends CrudRepository<UserScore, Integer> {
}
