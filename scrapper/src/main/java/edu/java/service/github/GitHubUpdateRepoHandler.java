package edu.java.service.github;

import edu.java.client.github.GitHubClient;
import edu.java.client.github.dto.CommitCommentEventResponse;
import edu.java.client.github.dto.CreateEventsResponse;
import edu.java.client.github.dto.EventResponse;
import edu.java.client.github.dto.IssueEventResponse;
import edu.java.client.github.dto.PushEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class GitHubUpdateRepoHandler {
    private final GitHubClient gitHubClient;

    public GitHubUpdateRepoResult handle(String owner, String repository, String lastUpdateDate) {
        List<EventResponse> eventResponses = gitHubClient.fetchEvents(owner, repository).reversed().reversed()
            .stream()
            .filter(Objects::nonNull)
            .filter(resp -> resp.getCreatedAt().isAfter(OffsetDateTime.parse(lastUpdateDate))).toList();

        return new GitHubUpdateRepoResult(eventResponses.stream().map(this::getEventDescription).filter(Objects::nonNull).toList());
    }

    private String getEventDescription(EventResponse eventResponse) {
        if (eventResponse instanceof CommitCommentEventResponse commitCommentEventResponse) {
            return String.format(
                "Commit Comment Event. Action: %s. Commit id: %s. Body: %s. HTML URL: %s. User: %s%n",
                commitCommentEventResponse.getPayload().getAction(),
                commitCommentEventResponse.getPayload().getComment().commitId(),
                commitCommentEventResponse.getPayload().getComment().body(),
                commitCommentEventResponse.getPayload().getComment().htmlUrl(),
                commitCommentEventResponse.getPayload().getComment().user()
            );
        } else if (eventResponse instanceof IssueEventResponse issueEventResponse) {
            return String.format(
                "Issue Comment Event. Action: %s. Issue HTML URL: %s. Issue URL: %s. Issue Title: %s" +
                    "Issue State: %s. Issue Body: %s. Issue User: %s%n",
                issueEventResponse.getPayload().getAction(),
                issueEventResponse.getPayload().getIssue().htmlUrl(),
                issueEventResponse.getPayload().getIssue().url(),
                issueEventResponse.getPayload().getIssue().title(),
                issueEventResponse.getPayload().getIssue().state(),
                issueEventResponse.getPayload().getIssue().body(),
                issueEventResponse.getPayload().getIssue().user()
                );

        }else if(eventResponse instanceof CreateEventsResponse createEventsResponse){
            return String.format("" +
                "Create Event. Ref: %s. Ref type: %s%n",
                createEventsResponse.getPayload().getRef(),
            createEventsResponse.getPayload().getRefType());
        }else if (eventResponse instanceof PushEventResponse pushEventResponse){
            return  String.format(
                "Push Event. Push ID: %s. Commits pushed: %s. Ref: %s%n",
                pushEventResponse.getPayload().getPushId(),
                pushEventResponse.getPayload().getCommits(),
                pushEventResponse.getPayload().getRef()
            );
        }
        return null;
    }

}
