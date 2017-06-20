package main.facade.Services;

import main.domain.user.profile.HeadUpProfile;
import main.domain.user.profile.Profile;
import main.persistence.user.profile.HeadUpProfileRepository;
import main.persistence.user.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;

/**
 * Created by Joel on 21.06.2017.
 */
@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private HeadUpProfileRepository headUpProfileRepository;


    public Profile getProfile(int bnt, String username) throws NonUniqueResultException {
        Profile result = null;
        HeadUpProfile headUpProfile = null;
        headUpProfile = headUpProfileRepository.findByBntAndUsername(bnt, username);
        result = profileRepository.findByHeadUpProfile(headUpProfile);
        return result;
    }


}
