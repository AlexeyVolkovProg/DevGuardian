package edu.java.client.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.java.client.github.dto.records.CommitCommentResponse;
import java.io.Serializable;
import lombok.Getter;

@Getter
public class CommitCommentEventResponse extends EventResponse {

    @JsonProperty("payload")
    private EventPayload payload;

    @Getter
    public static class EventPayload implements Serializable {
        @JsonProperty("action")
        private String action;

        @JsonProperty("comment")
        private CommitCommentResponse comment;
    }
}
