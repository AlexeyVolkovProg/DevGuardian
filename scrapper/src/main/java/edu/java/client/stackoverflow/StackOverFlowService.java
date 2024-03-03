package edu.java.client.stackoverflow;

import edu.java.client.stackoverflow.dto.ListAnswerResponse;
import edu.java.client.stackoverflow.dto.ListCommentsResponse;
import edu.java.client.stackoverflow.dto.ListRelatedQuestionsResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface StackOverFlowService {
    @GetExchange("/questions/{id}/answers")
    ListAnswerResponse getAnswerEvents(
        @PathVariable("id") String questionId,
        @RequestParam(value = "site", defaultValue = "stackoverflow") String site
    );

    @GetExchange("/questions/{id}/comments")
    ListCommentsResponse getCommentsEvents(
        @PathVariable("id") String questionId
    );

    @GetExchange("/questions/{id}/related")
    ListRelatedQuestionsResponse getRelatedQuestionsEvents(
        @PathVariable("id") String questionId
    );

}
