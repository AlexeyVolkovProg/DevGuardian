package edu.java.linkparser;

import edu.java.linkparser.response.ParsingResponse;
import java.util.Optional;

public interface LinkParser {
    ParsingResponse parse(String text);
}
