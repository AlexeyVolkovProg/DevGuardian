package edu.java.configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GitHubConfiguration {
    public static final String API_BASE_URL = "https://api.github.com/";
    public static final String API_VERSION_SPEC = "application/vnd.github.v3+json";
    public static final String JSON_CONTENT_TYPE = MediaType.APPLICATION_JSON_VALUE;
}
