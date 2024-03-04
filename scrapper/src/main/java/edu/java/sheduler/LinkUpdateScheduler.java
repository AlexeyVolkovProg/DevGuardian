package edu.java.sheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

public class LinkUpdateScheduler {
    Logger logger = LogManager.getLogger(LinkUpdateScheduler.class);

    @Scheduled(fixedDelayString = "#{scheduler.interval().toMillis()}")
    public void update() {
        logger.info("check updates");
    }
}
