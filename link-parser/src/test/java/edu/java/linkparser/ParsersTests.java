package edu.java.linkparser;

import edu.java.linkparser.response.GitHubResponse;
import edu.java.linkparser.response.ParsingResponse;
import edu.java.linkparser.response.StackOverflowResponse;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private ParseService createLinkParsers() {
        return new ParseService(new GitHubParser(), new StackOverflowParser());
    }
    @Test
    public void testGithubLinks() {
        final ParseService parseService = createLinkParsers();
        final String correctLink1 = "https://github.com/chemistry-lab/chemistry-lab-vr";
        final String correctLink2 = "https://github.com/sanyarnd/tinkoff-java-course-2023/";
        final ParsingResponse parsingResult1 = parseService.parseLink(correctLink1);
        final ParsingResponse parsingResult2 = parseService.parseLink(correctLink2);
        assertEquals(new GitHubResponse("chemistry-lab", "chemistry-lab-vr"), parsingResult1);
        assertEquals(new GitHubResponse("sanyarnd", "tinkoff-java-course-2023"), parsingResult2);
    }
    @Test
    public void testStackOverFlowLinks() {
        final ParseService parseService = createLinkParsers();
        final String correctLink1 =
            "https://stackoverflow.com/questions/11227809/why-is-processing-a-sorted-array-faster-than-processing-an-unsorted-array";
        final String correctLink2 =
            "https://stackoverflow.com/questions/8318911/why-does-html-think-chucknorris-is-a-color";
        final ParsingResponse parsingResult1 = parseService.parseLink(correctLink1);
        final ParsingResponse parsingResult2 = parseService.parseLink(correctLink2);
        assertEquals(new StackOverflowResponse("11227809"), parsingResult1);
        assertEquals(new StackOverflowResponse("8318911"), parsingResult2);
    }

}
