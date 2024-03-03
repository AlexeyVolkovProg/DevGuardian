package edu.java.configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StackOverFlowConfiguration {
    public static final String API_BASE_URL = "https://api.stackexchange.com/";
    public static final String API_VERSION_SPEC = "2.3";
    public static final String JSON_CONTENT_TYPE = MediaType.APPLICATION_JSON_VALUE;
}
