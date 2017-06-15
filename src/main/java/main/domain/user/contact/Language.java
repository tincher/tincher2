package main.domain.user.contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Joel on 11.06.2017.
 */
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String language;

    public Language() {
    }

    public String getLanguage() {
        return language;
    }

    public Language setLanguage(java.lang.String language) {
        this.language = language;
        return this;
    }

}
