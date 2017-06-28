package main.domain.user.stats;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 11.06.2017.
 */
@Entity
public class ChampionStats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "cstats_statblock",
            joinColumns = @JoinColumn(name = "cstats_id"),
            inverseJoinColumns = @JoinColumn(name = "statblock_id")
    )
    private List<StatBlock> statBlocks;


    public List<StatBlock> getStatBlocks() {
        return statBlocks;
    }

    public void setStatBlocks(List<StatBlock> statBlocks) {
        this.statBlocks = statBlocks;
    }

    public void addStatBlock(StatBlock statBlock) {
        if(this.statBlocks == null){
            this.statBlocks = new ArrayList<>();
        }
        this.statBlocks.add(statBlock);
    }

}
