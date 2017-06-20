package main.facade.RESTController;

import main.domain.user.profile.Profile;
import main.facade.Services.ProfileService;
import main.persistence.user.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NonUniqueResultException;

/**
 * Created by Joel on 15.06.2017.
 */
@RestController
@RequestMapping("profile")
public class ProfileRestController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileService profileService;


    @RequestMapping(value = "/{bnt}/{username}", method = RequestMethod.GET)
    public Profile getProfile(@PathVariable("bnt") int bnt, @PathVariable("username") String username) {
        try {
            Profile result = profileService.getProfile(bnt, username);
            return result;
        } catch (NonUniqueResultException e) {
            return  null;
        }
    }


}
