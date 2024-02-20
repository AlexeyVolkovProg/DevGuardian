package edu.java.bot.commands.handlers;

import edu.java.bot.commands.Command;
import edu.java.bot.commands.impl.HelpCommand;
import edu.java.bot.commands.impl.StartCommand;
import edu.java.bot.commands.impl.TrackCommand;
import edu.java.bot.commands.impl.UntrackedCommand;
import edu.java.bot.commands.info.CommandsInfo;
import edu.java.bot.commands.info.SupportingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;
import java.util.Map;

@Component
public class CommandHandler {

    private final Map<String, Command> commandsMap;

    @Autowired
    public CommandHandler(
        StartCommand startCommand,
        HelpCommand helpCommand,
        TrackCommand trackCommand,
        UntrackedCommand untrackedCommand
    ) {
            this.commandsMap = Map.of(
                CommandsInfo.START.getValue(), startCommand,
                CommandsInfo.HELP.getValue(), helpCommand,
                CommandsInfo.TRACK.getValue(), trackCommand,
                CommandsInfo.UNTRACKED.getValue(), untrackedCommand
            );
    }




    /**
     * Обработка пришедшей команды
     */
    public SendMessage handleCommand(Update update) {
        String info = update.getMessage().getText();
        List<String> commandInfo = List.of(info.split(" "));
        String commandName = commandInfo.getFirst();
        long chatId = update.getMessage().getChatId();

        Command commandIdentification = commandsMap.get(commandName);
        if (commandIdentification != null){
            System.out.println("Обработка команды");
            return commandIdentification.execute(update);
        }else {
            return new SendMessage(String.valueOf(chatId), SupportingInfo.UNKNOWN_COMMAND.getDescription());
        }
    }

}
