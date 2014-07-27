package itwise.coreasset.github;

import hadrian.meta.API;
import hadrian.meta.http.GET;
import hadrian.meta.http.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by chanwook on 2014. 7. 26..
 */
@API(key = "github-repository")
public interface GithubRepositoryApiSpec {

    //TODO defaultValue = "all" 추가!
    /**
     * spec: https://developer.github.com/v3/repos/#list-organization-repositories
     *
     * @param orgName
     * @param type    조회 repository 유형 (all, public, private, forks, sources, member 중 하나)
     * @return
     */
    @GET(url = "/orgs/{1}/repos")
    //TODO 매핑 기능...매핑하기에는 컬럼이 너무 많아서 일단 안함@@ 
    List<Repository> getOrganizationRepositories(String orgName, @Param(value = "type") String type);

    @GET(url = "/orgs/{1}/repos")
    String getOrganizationRepositoriesAsString(String orgName, @Param(value = "type") String type);

    @GET(url = "/orgs/{1}/repos")
    List<Map> getOrganizationRepositoriesAsMap(String orgName, @Param(value = "type") String type);
}
