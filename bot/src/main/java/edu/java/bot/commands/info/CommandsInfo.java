package edu.java.bot.commands.info;

public enum CommandsInfo {

    START("/start", "Старт работы бота"),
    HELP("/help", "Вывод информации о всех доступных командах"),
    TRACK("/track", "Включает отслеживание отправленной ссылки"),
    UNTRACKED("/untracked", "Снимает ссылку с отслеживания");

    String value;
    String description;

    CommandsInfo(String s, String s1) {
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
