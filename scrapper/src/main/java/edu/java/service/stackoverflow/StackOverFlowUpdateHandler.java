package edu.java.service.stackoverflow;

import edu.java.client.stackoverflow.StackOverFlowClient;
import edu.java.client.stackoverflow.dto.ListAnswerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StackOverFlowUpdateHandler {
    private final StackOverFlowClient stackOverFlowClient;

    public List<String> handleAnswer(String questionId, String lastUpdateDate){
        return stackOverFlowClient.fetchAnswerEvents(questionId).getAnswers().stream().map(this::getAnswerContents).toList();
    }

    public String getAnswerContents(ListAnswerResponse.AnswerEventResponse answerEventResponse){
        return String.format("Answer id: %s. Answer: %s. Creation date: %s. Is accepted: %s. Score: %s. Owner: %s",
            answerEventResponse.answerId(),
            answerEventResponse.body(),
            answerEventResponse.creationDate(),
            answerEventResponse.isAccepted(),
            answerEventResponse.score(),
            answerEventResponse.owner());
    }
}
