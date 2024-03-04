package edu.java.client.stackoverflow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class ListAnswerResponse {
    @JsonProperty("items")
    private List<AnswerEventResponse> answers;

    public record AnswerEventResponse(
        @JsonProperty("owner") UserInformationResponse owner,
        @JsonProperty("answer_id") long answerId,
        @JsonProperty("is_accepted") boolean isAccepted,
        @JsonProperty("score") int score,
        @JsonProperty("creation_date") OffsetDateTime creationDate,
        @JsonProperty("body") String body
    ) {
    }
}