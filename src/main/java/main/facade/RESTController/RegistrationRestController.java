package main.facade.RESTController;

import main.domain.registration.Registration;
import main.domain.user.User;
import main.domain.user.profile.Profile;
import main.facade.DataFetcher.DataFetcher;
import main.facade.Services.SHAService;
import main.persistence.registration.RegistrationRepository;
import main.persistence.user.UserRepository;
import main.persistence.user.profile.HeadUpProfileRepository;
import main.persistence.user.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Joel on 11.06.2017.
 */
@RestController
@RequestMapping("register")
public class RegistrationRestController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private HeadUpProfileRepository headUpProfileRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    private SHAService shaService = new SHAService();

    private DataFetcher dataFetcher = new DataFetcher();

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String test() {
//        return "Success";
//    }

    @RequestMapping(method = RequestMethod.POST)
    public User register(@RequestBody Registration reg) throws NoSuchAlgorithmException {
        Registration registration = new Registration().setBnt(reg.getBnt()).setUsername(reg.getUsername());
        registrationRepository.save(registration);
        try {
            Profile profile = dataFetcher.fetchForNewUser(registration);
            profileRepository.save(profile);
            User user = new User().setUsername(reg.getUsername() + "#" + reg.getBnt()).setPassword(shaService.getEncrypted(reg.getPassword()));
            userRepository.save(user);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


}
