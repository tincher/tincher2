package main.domain.user.contact;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 11.06.2017.
 */
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "contact_languages",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "language")
    )
    private List<Language> languages;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "contact_talking_possibilities",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "talking_possibility")
    )
    private List<TalkingPossibility> talkingPossibilities;


    public Contact() {
        this.setLanguages(new ArrayList<>()).setTalkingPossibilities(new ArrayList<>());
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public Contact setLanguages(List<Language> languages) {
        this.languages = languages;
        return this;
    }

    public Contact addLanguage(String language) {
        if (this.languages == null) {
            this.languages = new ArrayList<>();
        }
        this.languages.add(new Language().setLanguage(language));
        return this;
    }

    public List<TalkingPossibility> getTalkingPossibilities() {
        return talkingPossibilities;
    }

    public Contact setTalkingPossibilities(List<TalkingPossibility> talkingPossibilities) {
        this.talkingPossibilities = talkingPossibilities;
        return this;
    }

    public Contact addTalkingPossibility(String talkingPossibilities) {
        if (this.talkingPossibilities == null) {
            this.talkingPossibilities = new ArrayList<>();
        }
        this.talkingPossibilities.add(new TalkingPossibility().setTalkingPossibility(talkingPossibilities));
        return this;
    }

}
