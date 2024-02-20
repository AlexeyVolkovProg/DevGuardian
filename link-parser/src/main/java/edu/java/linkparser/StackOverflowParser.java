package edu.java.linkparser;

import edu.java.linkparser.response.ParsingResponse;
import edu.java.linkparser.response.StackOverflowResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackOverflowParser implements LinkParser{
    private static final String SOF_PATTERN = "^https://stackoverflow\\.com/questions/(\\d+)(/|$)";

    @Override
    public ParsingResponse parse(String text) {
        Pattern pattern =Pattern.compile(SOF_PATTERN);
        Matcher matcher = pattern.matcher(text.trim());
        if (matcher.find()){
            String idQuestion = matcher.group(1);
            return new StackOverflowResponse(idQuestion);
        }
        return null;
    }
}
