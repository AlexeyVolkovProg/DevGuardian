package edu.java.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
public class GitHubConfiguration {
    public static String API_BASE_URL = "https://api.github.com/";
    public static String API_VERSION_SPEC = "application/vnd.github.v3+json";
    public static String JSON_CONTENT_TYPE = MediaType.APPLICATION_JSON_VALUE;
}
