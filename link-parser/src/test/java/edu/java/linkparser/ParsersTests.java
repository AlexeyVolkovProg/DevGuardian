package edu.java.linkparser;

import edu.java.linkparser.response.GitHubResponse;
import edu.java.linkparser.response.ParsingResponse;
import edu.java.linkparser.response.StackOverflowResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class ParsersTests {
    private ParseService createLinkParsers() {
        return new ParseService(new GitHubParser(), new StackOverflowParser());
    }
    @Test
    public void testGithubLinks() {
        final ParseService parseService = createLinkParsers();
        final String correctLink1 = "https://github.com/AlexeyVolkovProg/FinalLabBack";
        final String correctLink2 = "https://github.com/AlexeyVolkovProg/WebThirdLab";
        final ParsingResponse parsingResult1 = parseService.parseLink(correctLink1);
        final ParsingResponse parsingResult2 = parseService.parseLink(correctLink2);
        assertEquals(new GitHubResponse("AlexeyVolkovProg", "FinalLabBack"), parsingResult1);
        assertEquals(new GitHubResponse("AlexeyVolkovProg", "WebThirdLab"), parsingResult2);
    }
    @Test
    public void testStackOverFlowLinks() {
        final ParseService parseService = createLinkParsers();
        final String correctLink1 =
            "https://stackoverflow.com/questions/5562936/how-maven-know-which-archetype-is-used";
        final String correctLink2 =
            "https://stackoverflow.com/questions/40538736/what-is-the-use-of-the-property-archetypeversion-in-maven?rq=3";
        final ParsingResponse parsingResult1 = parseService.parseLink(correctLink1);
        final ParsingResponse parsingResult2 = parseService.parseLink(correctLink2);
        assertEquals(new StackOverflowResponse("5562936"), parsingResult1);
        assertEquals(new StackOverflowResponse("40538736"), parsingResult2);
    }

}
