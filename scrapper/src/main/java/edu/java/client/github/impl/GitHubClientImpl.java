package edu.java.client.github.impl;

import edu.java.client.github.GitHubClient;
import edu.java.client.github.GitHubRepositoryService;
import edu.java.client.github.dto.EventResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GitHubClientImpl implements GitHubClient {
    private final GitHubRepositoryService gitHubRepositoryService;

    @Override
    public List<EventResponse> fetchEvents(String username, String repository) {
        return gitHubRepositoryService.getEvents(repository, username);
    }
}
