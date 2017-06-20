package main.facade.DataFetcher;

import main.domain.stat_block.StatBlock;
import main.domain.user.profile.HeadUpProfile;
import main.domain.user.profile.Profile;
import main.domain.registration.Registration;
import main.domain.user.stats.Champion;
import main.domain.user.stats.ChampionStats;
import main.domain.user.stats.PlayedChamps;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Joel on 11.06.2017.
 */
public class DataFetcher {
    private final String URL = "https://playoverwatch.com/de-de/career/pc/eu/";
    private final String URL_SEARCH = "https://playoverwatch.com/de-de/search?q=";




    public Profile fetchForNewUser(Registration registration) throws IOException {
        //Init profile
        Profile result = new Profile(registration);

        //JSOUP part
        Document doc = null;
        doc = Jsoup.connect(URL + registration.getUsername() + "-" + String.valueOf(registration.getBnt())).timeout(20 * 1000).get();
        Element champstats = doc.getElementById("competitive");

        result.getHeadUpProfile().setProfileImgUrl(doc.getElementsByClass("player-portrait").get(0).attr("src"));

        if (champstats != null && champstats.getElementsByClass("career-stats-section") != null) {

            //Getting comp stats - Overall & Champion specific
            Elements dataTableElems = champstats.getElementById("competitive").getElementsByAttributeValue("data-group-id", "stats");

            //Init PlayedChamps
            PlayedChamps playedChamps = new PlayedChamps();

            for (int i = 1; i < dataTableElems.get(0).getElementsByTag("option").size(); i++) {
                Champion champion = new Champion();
                champion.setName(dataTableElems.get(0).getElementsByTag("option").get(i).text());
                playedChamps.addToChampList(champion);
            }

            //remove select item and overall stats
            dataTableElems.remove(0);
            dataTableElems.remove(0);

            for (Element elem : dataTableElems) {

                //Init Champstats
                ChampionStats championStats = new ChampionStats();
                Elements blockStats = elem.getElementsByTag("tbody");

                int i = 0;
                for (Element stat : blockStats) {
                    //Init ChampStats
                    StatBlock statBlock = new StatBlock();
                    statBlock.setBlockname(elem.getElementsByClass("stat-title").get(i).text());

                    //iter through statcard
                    int j = 0, k = 1;
                    while (stat.getElementsByTag("td").size() >= k) {
                        statBlock.addValueToMap(stat.getElementsByTag("td").get(j).text(), stat.getElementsByTag("td").get(k).text());
                        j += 2;
                        k += 2;
                    }
                    championStats.addStatBlock(statBlock);
                    i++;
                }

                //set statblocks to fitting champ
                for (Champion champion : playedChamps.getChampionList()) {
                    if (champion.getChampionStats() == null) {
                        champion.setChampionStats(championStats);
                        break;
                    }
                }
            }
            result.getHeadUpProfile().setPlayedChamps(playedChamps);
        }
        return result;
    }
}
