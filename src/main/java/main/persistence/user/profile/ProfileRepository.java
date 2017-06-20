package main.persistence.user.profile;

import main.domain.user.profile.HeadUpProfile;
import main.domain.user.profile.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joel on 11.06.2017.
 */
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    public Profile findByHeadUpProfile(HeadUpProfile headUpProfile);


}
