package main.persistence.user;

import main.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joel on 28.06.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String username);

}
