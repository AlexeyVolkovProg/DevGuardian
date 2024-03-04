package edu.java.configuration;

import edu.java.sheduler.Scheduler;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = true)
public record ApplicationConfig(
    @NotNull
    Scheduler scheduler
) {
}
