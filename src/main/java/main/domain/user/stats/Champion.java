package main.domain.user.stats;

import javax.persistence.*;

/**
 * Created by Joel on 11.06.2017.
 */
@Entity
public class Champion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    private ChampionStats championStats;

    public String getName() {
        return name;
    }

    public Champion setName(String name) {
        this.name = name;
        return this;
    }

    public ChampionStats getChampionStats() {
        return championStats;
    }

    public Champion setChampionStats(ChampionStats championStats) {
        this.championStats = championStats;
        return this;
    }
}
