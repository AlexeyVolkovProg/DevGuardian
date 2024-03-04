package edu.java.bot.commands.info;

import lombok.Getter;

@Getter public enum SupportingInfo {

    START_BOT("Здравствуйте. Я бот, который поможет отслеживать вам изменение происходящие, "
        + "в Github репозиториях и топиках SOF. Для просмотра доступных команд введите /help"),
    UNKNOWN_MESSAGE("Данное сообщение не поддерживается. Введите команду. Ввод команды начинается с /"),
    UNKNOWN_COMMAND("Данная команда не поддерживается. Чтобы посмотреть список доступных команд, "
        + "введите /help");

    final String description;

    SupportingInfo(String description) {
        this.description = description;
    }

}
