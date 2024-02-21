package edu.java.linkparser.response;

public record GitHubResponse(String name, String repository) implements ParsingResponse {
}
