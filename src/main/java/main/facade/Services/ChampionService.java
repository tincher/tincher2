package main.facade.Services;

import main.domain.user.stats.ChampionName;
import main.domain.user.stats.Roles;
import org.springframework.stereotype.Service;

/**
 * Created by Joel on 30.06.2017.
 */
@Service
public class ChampionService {


    public Roles getChampionRole(ChampionName championName) {
        switch (championName) {
            case ANA:
                return Roles.SUPPORT;
            case DVA:
                return Roles.TANK;
            case MEI:
                return Roles.DEFENSIVE;
            case GENJI:
                return Roles.DPS;
            case HANZO:
                return Roles.DEFENSIVE;
            case LUCIO:
                return Roles.SUPPORT;
            case MERCY:
                return Roles.SUPPORT;
            case ORISA:
                return Roles.TANK;
            case ZARYA:
                return Roles.TANK;
            case MCCREE:
                return Roles.DPS;
            case PHARAH:
                return Roles.DPS;
            case REAPER:
                return Roles.DPS;
            case SOMBRA:
                return Roles.DPS;
            case TRACER:
                return Roles.DPS;
            case BASTION:
                return Roles.DEFENSIVE;
            case JUNKRAT:
                return Roles.DEFENSIVE;
            case ROADHOG:
                return Roles.TANK;
            case SOLDIER:
                return Roles.DPS;
            case WINSTON:
                return Roles.TANK;
            case SYMMETRA:
                return Roles.SUPPORT;
            case ZENYATTA:
                return Roles.SUPPORT;
            case REINHARDT:
                return Roles.TANK;
            case TORBJOERN:
                return Roles.DEFENSIVE;
            case WIDOWMAKER:
                return Roles.DEFENSIVE;
            default:
                return Roles.NONE;
        }
    }

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
