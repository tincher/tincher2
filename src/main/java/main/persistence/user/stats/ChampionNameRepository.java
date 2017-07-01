package main.persistence.user.stats;

import main.domain.user.stats.ChampionName;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Joel on 02.07.2017.
 */
public interface ChampionNameRepository extends CrudRepository<ChampionName, Integer> {
}
