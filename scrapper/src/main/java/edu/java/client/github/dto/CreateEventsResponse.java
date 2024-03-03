package edu.java.client.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class CreateEventsResponse extends EventResponse{

    @JsonProperty("payload")
    private EventPayload payload;
    @Getter
    public static class EventPayload implements Serializable{
        @JsonProperty("ref")
        private String ref;
        @JsonProperty("ref_type")
        private String refType;
    }
}
