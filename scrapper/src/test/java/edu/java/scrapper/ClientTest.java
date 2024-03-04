package edu.java.scrapper;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import edu.java.client.github.GitHubClient;
import edu.java.client.stackoverflow.StackOverFlowClient;
import edu.java.configuration.ClientConfiguration;
import edu.java.service.github.GitHubUpdateRepoHandler;
import edu.java.service.github.GitHubUpdateRepoResult;
import edu.java.service.stackoverflow.StackOverFlowUpdateHandler;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class ClientTest {

    private ClientConfiguration clientConfiguration;
    private GitHubClient gitHubClient;

    private StackOverFlowClient stackOverFlowClient;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();
    //используется для запуска и остановки экземпляра WireMockServer перед и после выполнения каждого теста.

    @Before
    public void setUp(){
        clientConfiguration = new ClientConfiguration();
        gitHubClient = clientConfiguration.githubClient();
        stackOverFlowClient = clientConfiguration.stackOverFlowClient();
    }

    @Test
    public void testGitHubClient(){
       stubFor(get(urlEqualTo("/repos/pydantic/FastUI/events"))
           .willReturn(aResponse().withHeader("Content-Type", "application/json")));
        GitHubUpdateRepoHandler gitHubUpdateRepoHandler = new GitHubUpdateRepoHandler(gitHubClient);
        GitHubUpdateRepoResult result = gitHubUpdateRepoHandler.handle("pydantic", "FastUI", "2024-01-01T00:00:00Z");
        assertNotNull(result);
    }

    @Test
    public void testStackOverFlowClient(){
        stubFor(get(urlEqualTo("/questions/{id}/answers")).willReturn(aResponse().withHeader("Content-Type","application/json")));
        StackOverFlowUpdateHandler stackOverFlowUpdateHandler = new StackOverFlowUpdateHandler(stackOverFlowClient);
        List<String> answers = stackOverFlowUpdateHandler.handleAnswer("78101775", "2024-01-01T00:00:00Z");
        assertNotNull(answers);
    }




}
