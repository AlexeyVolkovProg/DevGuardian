package edu.java.client.github;

import edu.java.client.github.dto.EventResponse;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface GitHubRepositoryService {
    @GetExchange("/repos/{owner}/{repo}/events")
    List<EventResponse> getEvents(
        @PathVariable("repo") String repo, @PathVariable("owner") String owner
    );
}
