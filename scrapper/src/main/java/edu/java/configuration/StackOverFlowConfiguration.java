package edu.java.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
public class StackOverFlowConfiguration {
    public static String API_BASE_URL = "https://api.stackexchange.com/";
    public static String API_VERSION_SPEC = "2.3";
    public static String JSON_CONTENT_TYPE = MediaType.APPLICATION_JSON_VALUE;
}
