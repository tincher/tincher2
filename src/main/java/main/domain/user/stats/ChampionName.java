package main.domain.user.stats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Joel on 30.06.2017.
 */
@Entity
public enum ChampionName {

    GENJI, MCCREE, PHARAH, REAPER, SOLDIER, SOMBRA, TRACER, BASTION, HANZO, JUNKRAT, MEI, TORBJOERN, WIDOWMAKER,
    DVA, ORISA, REINHARDT, ROADHOG, WINSTON, ZARYA, ANA, LUCIO, MERCY, SYMMETRA, ZENYATTA, FALLBACK;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
