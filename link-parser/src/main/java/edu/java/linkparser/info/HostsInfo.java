package edu.java.linkparser.info;

public enum HostsInfo {
    GITHUB_LINK("github.com"),
    STACKOVERFLOW_LINK("stackoverflow.com");

    private final String value;

    HostsInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
