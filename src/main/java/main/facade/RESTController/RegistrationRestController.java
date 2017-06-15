package main.facade.RESTController;

import main.domain.registration.Registration;
import main.domain.user.profile.Profile;
import main.facade.DataFetcher.DataFetcher;
import main.persistence.user.RegistrationRepository;
import main.persistence.user.profile.HeadUpProfileRepository;
import main.persistence.user.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Joel on 11.06.2017.
 */
@RestController
@RequestMapping("registration")
public class RegistrationRestController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private HeadUpProfileRepository headUpProfileRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    private DataFetcher dataFetcher = new DataFetcher();

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "Success";
    }

    @RequestMapping(value = "/register/{bnt}/{username}")
    public void register(@PathVariable("bnt") int bnt, @PathVariable("username") String username) {
        Registration registration = new Registration().setBnt(bnt).setUsername(username).setRegistrationDate(new Date());
        registrationRepository.save(registration);
        DataFetcher dataFetcher = new DataFetcher();
        try {
            Profile profile = dataFetcher.fetchForNewUser(registration);
//            headUpProfileRepository.save(profile.getHeadUpProfile());
            profileRepository.save(profile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
