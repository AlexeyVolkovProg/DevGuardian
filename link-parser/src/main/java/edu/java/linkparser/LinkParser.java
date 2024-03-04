package edu.java.linkparser;

import edu.java.linkparser.response.ParsingResponse;

public interface LinkParser {
    ParsingResponse parse(String text);
}
