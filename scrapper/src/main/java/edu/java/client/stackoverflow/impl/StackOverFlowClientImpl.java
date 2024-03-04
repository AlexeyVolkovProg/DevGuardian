package edu.java.client.stackoverflow.impl;

import edu.java.client.stackoverflow.StackOverFlowClient;
import edu.java.client.stackoverflow.StackOverFlowService;
import edu.java.client.stackoverflow.dto.ListAnswerResponse;
import edu.java.client.stackoverflow.dto.ListCommentsResponse;
import edu.java.client.stackoverflow.dto.ListRelatedQuestionsResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StackOverFlowClientImpl implements StackOverFlowClient {

    private final StackOverFlowService stackOverFlowService;

    @Override
    public ListAnswerResponse fetchAnswerEvents(String questionId) {
        return stackOverFlowService.getAnswerEvents(questionId, null);
    }

    @Override
    public ListCommentsResponse fetchCommentEvents(String questionId) {
        return stackOverFlowService.getCommentsEvents(questionId);
    }

    @Override
    public ListRelatedQuestionsResponse fetchRelatedQuestionEvent(String questionId) {
        return stackOverFlowService.getRelatedQuestionsEvents(questionId);
    }
}
