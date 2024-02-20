package edu.java.bot.bot;

import edu.java.bot.commands.handlers.CommandHandler;
import edu.java.bot.commands.info.SupportingInfo;
import edu.java.bot.configuration.ApplicationConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class DevGuardianBot extends TelegramLongPollingBot {

    Logger logger = LogManager.getLogger(DevGuardianBot.class);
    private final ApplicationConfig applicationConfig;

    private final CommandHandler commandHandler;

    @Autowired
    public DevGuardianBot(ApplicationConfig applicationConfig, CommandHandler commandHandler) {
        super(applicationConfig.telegramToken());
        this.applicationConfig = applicationConfig;
        this.commandHandler = commandHandler;
    }

    private void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Обработка приходящих сообщений
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            String currentInfo = update.getMessage().getText();
            if (currentInfo.startsWith("/")) {
                logger.info("Была считана команда" + currentInfo);
                sendMessage(commandHandler.handleCommand(update));
            } else {
                logger.info("Было считано необрабатываемое сообщение");
                message.setChatId(update.getMessage().getChatId());
                message.setText(SupportingInfo.UNKNOWN_MESSAGE.getDescription());
                sendMessage(message);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return applicationConfig.name();
    }
}
