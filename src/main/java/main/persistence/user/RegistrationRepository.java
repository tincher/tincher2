package main.persistence.user;

import main.domain.registration.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joel on 11.06.2017.
 */
@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
}
