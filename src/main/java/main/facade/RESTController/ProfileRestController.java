package main.facade.RESTController;

import main.domain.registration.Registration;
import main.domain.user.profile.Profile;
import main.domain.user.profile.TimeSpan;
import main.facade.DataFetcher.DataFetcher;
import main.facade.Services.ProfileService;
import main.persistence.user.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NonUniqueResultException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.LinkedHashMap;

/**
 * Created by Joel on 15.06.2017.
 */
@RestController
@RequestMapping("profile")
@CrossOrigin
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

    @RequestMapping(value = "/addUsualPlayTime/{bnt}/{username}", method = RequestMethod.POST)
    public void addUsualPlayTime(@PathVariable("bnt") int bnt, @PathVariable("username") String username, @RequestBody Object[] timeSpan) {
        Profile profile = getProfile(bnt, username);
        profile.getHeadUpProfile().addUsualPlayTime(new TimeSpan().setStartTime((LinkedHashMap) timeSpan[0]).setEndTime((LinkedHashMap) timeSpan[1]));
        profileRepository.save(profile);
    }

    @RequestMapping(value = "/emptyInterval")
    public LocalTime[] getInterval() {
        LocalTime[] array = new LocalTime[2];
        array[0] = LocalTime.now();
        array[1] = LocalTime.now();
        return array;
    }

//    @RequestMapping(value = "/setFavourite Champs/{bnt}/{username}", method = RequestMethod.POST)
//    public void setFavoriteChamps(@RequestBody List<ChampionName> favouriteChamps, @PathVariable("bnt") int bnt, @PathVariable("username") String username) {
//        Profile profile = getProfile(bnt, username);
//        profile.getHeadUpProfile().setFavoriteChamps(new FavoriteChamps());
//        profileRepository.save(profile);
//    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    public void updateProfile(@RequestBody Profile profile) {
        Profile savedProfile = getProfile(profile.getHeadUpProfile().getBnt(), profile.getHeadUpProfile().getUsername());
        profile.setId(savedProfile.getId());
        profileRepository.save(profile);
    }


}
