package edu.java.linkparser;

import edu.java.linkparser.response.GitHubResponse;
import edu.java.linkparser.response.ParsingResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Парсер ссылок с GitHub
 */

public class GitHubParser implements LinkParser{

    private static final String USER_REPO_REGEX = "^https://github.com/([\\w.-]+)/([\\w.-]+)(/$|$)";
    @Override
    public ParsingResponse parse(String text) {
        Pattern pattern = Pattern.compile(USER_REPO_REGEX);
        Matcher matcher = pattern.matcher(text.trim());
        if (matcher.find()){
            String username = matcher.group(1);
            String repository = matcher.group(2);
            return new GitHubResponse(username, repository);
        }
       return null;
    }
}
