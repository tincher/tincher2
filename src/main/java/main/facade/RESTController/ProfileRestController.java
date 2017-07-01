package main.facade.RESTController;

import main.domain.registration.Registration;
import main.domain.user.profile.Profile;
import main.domain.user.stats.ChampionName;
import main.facade.DataFetcher.DataFetcher;
import main.facade.Services.ProfileService;
import main.persistence.user.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.io.IOException;
import java.util.List;

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


    @RequestMapping(value = "/setFavourite Champs/{bnt}/{username}", method = RequestMethod.POST)
    public void setFavoriteChamps(@RequestBody List<ChampionName> favouriteChamps, @PathVariable("bnt") int bnt, @PathVariable("username") String username) {
        Profile profile = getProfile(bnt, username);
        profile.getHeadUpProfile().setFavoriteChamps(favouriteChamps);
        profileRepository.save(profile);
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public void updateProfile(@RequestBody Profile profile) {
        Profile savedProfile = getProfile(profile.getHeadUpProfile().getBnt(), profile.getHeadUpProfile().getUsername());
        profile.setId(savedProfile.getId());
        profileRepository.save(profile);
    }


}
