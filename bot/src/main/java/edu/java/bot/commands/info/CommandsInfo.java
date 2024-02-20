package edu.java.bot.commands.info;

import lombok.Getter;

@Getter public enum CommandsInfo {

    START("/start", "Старт работы бота"),
    HELP("/help", "Вывод информации о всех доступных командах"),
    TRACK("/track", "Включает отслеживание отправленной ссылки"),
    UNTRACKED("/untracked", "Снимает ссылку с отслеживания"),
    LIST("/list", "Выводит список отслеживаемых ссылок");

    final String value;
    final String description;

    CommandsInfo(String value, String description) {
        this.value = value;
        this.description = description;
    }

}
