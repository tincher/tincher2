package main.persistence.user.stats;

import main.domain.user.stats.Champion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joel on 14.06.2017.
 */
@Repository
public interface ChampionStatsRepository extends CrudRepository<Champion, Integer> {
}
