package edu.java.client.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.java.client.github.dto.records.IssueResponse;
import lombok.Getter;
import java.io.Serializable;

/**
 * Ответы с GET /repos/{owner}/{repo}/issues/events
 * Отслеживает события, происходящие c графой issues(баги и проблемы) в репозитории
 */

@Getter
public class IssueEventResponse extends EventResponse {
    @JsonProperty("payload")
    private EventPayload payload;

    public static class EventPayload implements Serializable{
        @JsonProperty("action")
        private String action;
        @JsonProperty("issue")
        private IssueResponse issue;
    }
}
