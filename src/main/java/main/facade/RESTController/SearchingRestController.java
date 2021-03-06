package main.facade.RESTController;

import main.domain.user.profile.Profile;
import main.domain.user.stats.Roles;
import main.facade.Services.SearchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Joel on 05.07.2017.
 */
@RestController
@RequestMapping("search")
public class SearchingRestController {

    @Autowired
    private SearchingService searchingService;


    @RequestMapping(value = "/idealMatch", method = RequestMethod.POST)
    public List<Profile> getIdealMatch(@RequestBody Profile profile) {
        return searchingService.findIdealProfile(profile, Roles.DPS);
    }

    @RequestMapping(value = "/fastMatch", method = RequestMethod.POST)
    public List<Profile> getFastMatch(@RequestBody Profile profile) {
        return searchingService.findFastProfile(profile);
    }


}
