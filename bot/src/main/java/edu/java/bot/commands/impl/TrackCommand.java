package edu.java.bot.commands.impl;

import edu.java.bot.commands.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class TrackCommand implements Command {
    @Override
    public SendMessage execute(Update update) {
        long chatId = update.getMessage().getChatId();
        return SendMessage.builder()
            .chatId(String.valueOf(chatId))
            .text("Команда будет реализована позже") // реализация появится, когда напишем HttpClient для общения(ДЗ2)
            .build();
    }
}
