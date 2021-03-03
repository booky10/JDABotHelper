package tk.booky.jdahelper.api.commands;
// Created by booky10 in JDABotHelper (16:21 03.03.21)

public interface IHelpTranslation {

    default String getHelpCommand() {
        return "help";
    }

    default String getMessageTitle() {
        return "__Command Help__";
    }

    default String getEntryFormat() {
        return "**%s%s** %s";
    }

    default String getSpecificFormat() {
        return "**%s%s**\n%s (_%s_)";
    }

    default String getNotFoundMessage() {
        return "The command %s could not be found!";
    }
}