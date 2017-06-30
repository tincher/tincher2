package main.domain.user.stats;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 11.06.2017.
 */
@Entity
public class Champion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private ChampionName name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cstats_statblock",
            joinColumns = @JoinColumn(name = "cstats_id"),
            inverseJoinColumns = @JoinColumn(name = "statblock_id")
    )
    private List<StatBlock> championStats;

    public ChampionName getName() {
        return name;
    }

    public Champion setName(ChampionName name) {
        this.name = name;
        return this;
    }

    public List<StatBlock> getChampionStats() {
        return championStats;
    }

    public Champion setStatBlocks(List<StatBlock> championStats) {
        this.championStats = championStats;
        return this;
    }

    public Champion addStatBlock(StatBlock statBlock) {
        if (this.championStats == null) {
            this.championStats = new ArrayList<>();
        }
        this.championStats.add(statBlock);
        return this;
    }
}
