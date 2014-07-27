package itwise.coreasset.github;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by chanwook on 2014. 7. 26..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {GithubAppConfig.class})
public class GithubRepositoryApiSpecTests {

    @Autowired
    private GithubRepositoryApiSpec spec;

    @Test
    public void config() throws Exception {

    }

    @Test
    public void getAllOrgPubRepository() throws Exception {
        String json = spec.getOrganizationRepositoriesAsString("coreasset", "all");
        assertNotNull(json);
        System.out.println(">>JSON: " + json);

        List<Map> map = spec.getOrganizationRepositoriesAsMap("coreasset", "all");
        assertNotNull(map);
        System.out.println(">>MAP: " + map);

    }
}
