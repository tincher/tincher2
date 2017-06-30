package main.facade.Services;

import main.domain.user.profile.Profile;
import main.facade.DataFetcher.DataFetcher;
import main.persistence.user.profile.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by Joel on 29.06.2017.
 */
@Component
public class UpdateService {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    @Autowired
    private ProfileRepository profileRepository;

    private DataFetcher dataFetcher = new DataFetcher();

    @Scheduled(fixedRate = 86400000)
    public void updateProfiles() {
        log.info("updating Profiles");
        List<Profile> profiles = (List<Profile>) profileRepository.findAll();
        for (Profile profile : profiles) {
            try {
                profileRepository.save(dataFetcher.fetchForExistingUser(profile));
                log.info(profile.getHeadUpProfile().getUsername() + "#" + profile.getHeadUpProfile().getBnt());
            } catch (IOException e) {
                log.error(profile.getHeadUpProfile().getUsername() + "#" + profile.getHeadUpProfile().getBnt());
            }
        }


    }

}
