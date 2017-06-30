package main.facade.Services;

import main.domain.user.stats.ChampionName;
import org.springframework.stereotype.Service;

/**
 * Created by Joel on 30.06.2017.
 */
@Service
public class ChampionNameService {

    public ChampionName getChampionName(String champName) {
        switch (champName) {
            case "Genji":
                return ChampionName.GENJI;
            case "McCree":
                return ChampionName.MCCREE;
            case "Pharah":
                return ChampionName.PHARAH;
            case "Reaper":
                return ChampionName.REAPER;
            case "Soldier: 76":
                return ChampionName.SOLDIER;
            case "Sombra":
                return ChampionName.SOMBRA;
            case "Tracer":
                return ChampionName.TRACER;
            case "Bastion":
                return ChampionName.BASTION;
            case "Hanzo":
                return ChampionName.HANZO;
            case "Junkrat":
                return ChampionName.JUNKRAT;
            case "Mei":
                return ChampionName.MEI;
            case "Torbjörn":
                return ChampionName.TORBJOERN;
            case "Widowmaker":
                return ChampionName.WIDOWMAKER;
            case "D.Va":
                return ChampionName.DVA;
            case "Orisa":
                return ChampionName.ORISA;
            case "Reinhardt":
                return ChampionName.REINHARDT;
            case "Roadhog":
                return ChampionName.ROADHOG;
            case "Winston":
                return ChampionName.WINSTON;
            case "Zarya":
                return ChampionName.ZARYA;
            case "Ana":
                return ChampionName.ANA;
            case "Lúcio":
                return ChampionName.LUCIO;
            case "Mercy":
                return ChampionName.MERCY;
            case "Symmetra":
                return ChampionName.SYMMETRA;
            case "Zenyatta":
                return ChampionName.ZENYATTA;
            default:
                return ChampionName.FALLBACK;
        }
    }
}
