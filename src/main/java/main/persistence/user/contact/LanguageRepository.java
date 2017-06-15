package main.persistence.user.contact;

import main.domain.user.contact.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joel on 11.06.2017.
 */
@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer>{

}
