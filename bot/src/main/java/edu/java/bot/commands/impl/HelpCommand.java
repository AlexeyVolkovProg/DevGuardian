package edu.java.bot.commands.impl;

import edu.java.bot.commands.Command;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class HelpCommand implements Command {
    @Override
    public SendMessage execute(Update update) {
        return null;
    }
}
