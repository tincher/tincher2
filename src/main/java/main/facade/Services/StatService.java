package main.facade.Services;

import main.domain.user.profile.HeadUpProfile;
import main.domain.user.stats.Champion;
import main.domain.user.stats.ChampionName;
import main.domain.user.stats.StatBlock;
import org.springframework.stereotype.Service;

/**
 * Created by Joel on 30.06.2017.
 */
@Service
public class StatService {

    public Champion getChampion(HeadUpProfile headUpProfile, ChampionName championName) {
        for (Champion champion : headUpProfile.getPlayedChamps().getChampionList()) {
            if (champion.getName() == championName) {
                return champion;
            }
        }
        return null;
    }

    public StatBlock getBlockInChampion(HeadUpProfile headUpProfile, ChampionName championName, String blockname) {
        Champion champion = getChampion(headUpProfile, championName);
        for (StatBlock statBlock : champion.getChampionStats()) {
            if (statBlock.getBlockname().equals(blockname)) {
                return statBlock;
            }
        }
        return null;
    }

    public String getValueFromStatblock(HeadUpProfile headUpProfile, ChampionName championName, String blockname, String key) {
        StatBlock statBlock = getBlockInChampion(headUpProfile, championName, blockname);
        return statBlock.getValueMap().get(key);
    }


}
