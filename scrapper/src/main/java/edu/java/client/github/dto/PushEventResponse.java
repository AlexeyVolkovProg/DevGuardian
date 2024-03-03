package edu.java.client.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.java.client.github.dto.EventResponse;
import lombok.Getter;
import java.io.Serializable;
import java.util.List;

public class PushEventResponse extends EventResponse {

    @JsonProperty("payload")
    private EventPayload payload;
    @Getter
    public static class EventPayload implements Serializable{
        @JsonProperty("push_id")
        private String pushId;
        @JsonProperty("ref")
        private String ref;
        @JsonProperty("commits")
        private List commits;
    }
}
