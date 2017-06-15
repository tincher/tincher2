package main.domain.user.stats;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 11.06.2017.
 */
@Entity
public class PlayedChamps {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "contact_languages",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "language")
    )
    private List<Champion> championList;

    public PlayedChamps() {
        this.championList = new ArrayList<>();
    }

    public List<Champion> getChampionList() {
        return championList;
    }

    public PlayedChamps setChampionList(List<Champion> championList) {
        this.championList = championList;
        return this;
    }

    public PlayedChamps addToChampList(Champion champion){
        if(this.championList == null){
            this.championList = new ArrayList<>();
        }
        this.championList.add(champion);
        return this;
    }
}
