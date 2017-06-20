package main.facade.RESTController;

import main.domain.registration.Registration;
import main.domain.user.profile.Profile;
import main.facade.DataFetcher.DataFetcher;
import main.facade.Services.ProfileService;
import main.persistence.user.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NonUniqueResultException;
import javax.xml.crypto.Data;
import java.io.IOException;

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

    @Autowired
    private DataFetcher dataFetcher;


    @RequestMapping(value = "/{bnt}/{username}", method = RequestMethod.GET)
    public Profile getProfile(@PathVariable("bnt") int bnt, @PathVariable("username") String username) {
        try {
            Profile result = profileService.getProfile(bnt, username);
            return result;
        } catch (NonUniqueResultException e) {
            return null;
        }
    }



    @RequestMapping(value = "/refreshProfile/{bnt}/{username}")
    public void refreshProfile(@PathVariable("bnt") int bnt, @PathVariable("username") String username) throws IOException {
        Profile profile = getProfile(bnt, username);
        profileRepository.delete(profile);
        profile = dataFetcher.fetchForNewUser(new Registration().setBnt(bnt).setUsername(username));
        profileRepository.save(profile);
    }




    @RequestMapping(value = "/refreshProfileImage/{bnt}/{username}")
    public void refreshProfileImage(@PathVariable("bnt") int bnt, @PathVariable("username") String username) throws IOException {
        Profile profile = getProfile(bnt, username);
        profile.getHeadUpProfile().setProfileImgUrl(dataFetcher.getProfileImage(bnt, username));
        profileRepository.save(profile);
    }





}
