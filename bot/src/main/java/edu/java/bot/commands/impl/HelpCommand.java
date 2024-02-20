package edu.java.bot.commands.impl;

import edu.java.bot.commands.Command;
import edu.java.bot.commands.info.CommandsInfo;
import jakarta.activation.CommandInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
@RequiredArgsConstructor
public class HelpCommand implements Command {
    @Override
    public SendMessage execute(Update update) {
        StringBuilder sb = new StringBuilder();
        sb.append("Доступный команды:\n");
        for (CommandsInfo botCommand : CommandsInfo.values()) {
            sb.append(botCommand.getValue()).append("\n");
        }
        long chatId = update.getMessage().getChatId();
        return SendMessage.builder()
            .chatId(String.valueOf(chatId))
            .text(sb.toString())
            .build();
    }
}
