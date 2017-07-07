package main.facade.Services;

import main.domain.user.profile.HeadUpProfile;
import main.domain.user.profile.Profile;
import main.domain.user.profile.TimeSpan;
import main.domain.user.stats.Champion;
import main.domain.user.stats.Roles;
import main.persistence.user.UserRepository;
import main.persistence.user.profile.HeadUpProfileRepository;
import main.persistence.user.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 05.07.2017.
 */
@Service
public class SearchingService {

    private static final int SEARCHINGRANGE = 300;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private HeadUpProfileRepository headUpProfileRepository;

    @Autowired
    private ChampionService championService;

    public List<Profile> findIdealProfile(Profile profile, Roles role) {
        List<Profile> result = new ArrayList<>();
        List<HeadUpProfile> compRankMatches = getCompRankMatches(profile);
        for (HeadUpProfile headUpProfile : compRankMatches) {
            for (Champion champion : headUpProfile.getPlayedChamps().getFavoriteChampionsList()) {
                if (championService.getChampionRole(champion.getName()) == role) {
                    result.add(profileRepository.findByHeadUpProfile(headUpProfile));
                    break;
                }
            }
        }
        return result;
    }

    public List<Profile> findFastProfile(Profile profile) {
        List<Profile> result = new ArrayList<>();
        List<HeadUpProfile> compRankMatches = getCompRankMatches(profile);
        for (HeadUpProfile compRankMatch : compRankMatches) {
            for (TimeSpan timeSpan : compRankMatch.getUsualPlayTime()) {
                if (timeSpan.contains(LocalTime.now())) {
                    result.add(profileRepository.findByHeadUpProfile(compRankMatch));
                }
            }
        }
        return result;
    }

    private List<HeadUpProfile> getCompRankMatches(Profile profile) {
        List<HeadUpProfile> compRankMatches = headUpProfileRepository.findAllByCompRankIsBetween(profile.getHeadUpProfile().getCompRank() - SEARCHINGRANGE, profile.getHeadUpProfile().getCompRank() + SEARCHINGRANGE);
        try {
            HeadUpProfile requestedHUP = headUpProfileRepository.findByBntAndUsername(profile.getHeadUpProfile().getBnt(), profile.getHeadUpProfile().getUsername());
            compRankMatches.remove(requestedHUP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return compRankMatches;
    }


}
