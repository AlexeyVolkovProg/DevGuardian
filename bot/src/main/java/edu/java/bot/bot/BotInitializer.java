package edu.java.bot.bot;

import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component

public class BotInitializer {

    private static final Logger LOGGER = LogManager.getLogger(BotInitializer.class);
    private final DevGuardianBot devGuardianBot;

    @Autowired
    public BotInitializer(DevGuardianBot devGuardianBot) {
        this.devGuardianBot = devGuardianBot;
    }

    @PostConstruct
    public void init() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botsApi.registerBot(devGuardianBot);
            LOGGER.info("Success register DevGuardianBot");
        } catch (TelegramApiException e) {
            LOGGER.error("Error register DevGuardianBot" + e.getMessage());
        }
    }

}
