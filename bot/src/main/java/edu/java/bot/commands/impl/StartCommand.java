package edu.java.bot.commands.impl;

import edu.java.bot.commands.Command;
import edu.java.bot.commands.info.SupportingInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class StartCommand implements Command {
    @Override
    public SendMessage execute(Update update) {
            long chatId = update.getMessage().getChatId();
            return SendMessage.builder()
                .chatId(String.valueOf(chatId))
                .text(SupportingInfo.START_BOT.getDescription())
                .build();
    }
}
