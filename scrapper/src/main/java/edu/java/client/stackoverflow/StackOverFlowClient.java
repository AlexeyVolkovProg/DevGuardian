package edu.java.client.stackoverflow;

import edu.java.client.stackoverflow.dto.ListAnswerResponse;
import edu.java.client.stackoverflow.dto.ListCommentsResponse;
import edu.java.client.stackoverflow.dto.ListRelatedQuestionsResponse;

public interface StackOverFlowClient {
    ListAnswerResponse fetchAnswerEvents(String questionId);

    ListCommentsResponse fetchCommentEvents(String questionId);

    ListRelatedQuestionsResponse fetchRelatedQuestionEvent(String questionId);
}
