package edu.java.configuration;

import edu.java.client.github.GitHubClient;
import edu.java.client.github.GitHubRepositoryService;
import edu.java.client.github.impl.GitHubClientImpl;
import edu.java.client.stackoverflow.StackOverFlowClient;
import edu.java.client.stackoverflow.StackOverFlowService;
import edu.java.client.stackoverflow.impl.StackOverFlowClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@SuppressWarnings("MagicNumber")
public class ClientConfiguration {

    //todo билд WebClient, возможно нуждается в доработке
    public <T> T buildClient(Class<T> clientClass, String apiUrl, String contentType, String apiVersion) {
        WebClient webClient = WebClient.builder()
            .baseUrl(apiUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, contentType)
            .defaultHeader(HttpHeaders.ACCEPT, apiVersion)
            .build();
        HttpServiceProxyFactory clientFactory =
            HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
        return clientFactory.createClient(clientClass);
    }

    private GitHubRepositoryService gitHubRepositoryService() {
        return buildClient(
            GitHubRepositoryService.class,
            GitHubConfiguration.API_BASE_URL,
            GitHubConfiguration.JSON_CONTENT_TYPE,
            GitHubConfiguration.API_VERSION_SPEC
        );
    }

    private StackOverFlowService stackOverFlowRepositoryService() {
        return buildClient(
            StackOverFlowService.class,
            StackOverFlowConfiguration.API_BASE_URL,
            StackOverFlowConfiguration.JSON_CONTENT_TYPE,
            StackOverFlowConfiguration.API_VERSION_SPEC
        );
    }

    @Bean
    public GitHubClient githubClient() {
        return new GitHubClientImpl(gitHubRepositoryService());
    }

    @Bean
    public StackOverFlowClient stackOverFlowClient() {
        return new StackOverFlowClientImpl(stackOverFlowRepositoryService());
    }
}





