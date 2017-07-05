package main.persistence.user.profile;

import main.domain.user.profile.HeadUpProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Joel on 14.06.2017.
 */
@Repository
public interface HeadUpProfileRepository extends CrudRepository<HeadUpProfile, Integer> {

    HeadUpProfile findByBntAndUsername(int bnt, String username);

    List<HeadUpProfile> findAllByCompRankIsBetween(int min, int max);

}
