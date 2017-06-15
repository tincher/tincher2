import main.domain.user.profile.Profile;
import main.domain.registration.Registration;
import main.facade.DataFetcher.DataFetcher;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Joel on 11.06.2017.
 */
public class DataFetcherTest {

    @Test
    public void fetchForNewUserTest() throws IOException {
        DataFetcher dataFetcher = new DataFetcher();
        Registration registration = new Registration().setBnt(2869).setUsername("Genetikk");
        Profile profile = dataFetcher.fetchForNewUser(registration);

        //TODO

        Assert.assertFalse(profile.equals(new Profile(registration)));
    }

}
