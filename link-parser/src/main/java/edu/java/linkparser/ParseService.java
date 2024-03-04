package edu.java.linkparser;

import edu.java.linkparser.info.HostsInfo;
import edu.java.linkparser.response.ParsingResponse;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class ParseService {
    GitHubParser gitHubParser;
    StackOverflowParser stackOverflowParser;

    public ParseService(GitHubParser gitHubParser, StackOverflowParser stackOverflowParser) {
        this.gitHubParser = gitHubParser;
        this.stackOverflowParser = stackOverflowParser;
    }

    public ParsingResponse parseLink(String link) {
        try {
            URL currentURL = new URL(link);
            currentURL.toURI();
            for (HostsInfo value : HostsInfo.values()) {
                if (currentURL.getHost().equals(value.getValue())) {
                    if (value.equals(HostsInfo.GITHUB_LINK)) {
                        return gitHubParser.parse(link);
                    } else if (value.equals(HostsInfo.STACKOVERFLOW_LINK)) {
                        return stackOverflowParser.parse(link);
                    }
                }
            }

        } catch (MalformedURLException | URISyntaxException e) {
            return null;
        }
        return null;
    }
}
