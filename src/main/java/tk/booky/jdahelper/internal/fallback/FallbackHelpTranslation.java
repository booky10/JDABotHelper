package tk.booky.jdahelper.internal.fallback;
// Created by booky10 in JDABotHelper (21:50 05.03.21)

import tk.booky.jdahelper.api.commands.IHelpTranslation;

public class FallbackHelpTranslation implements IHelpTranslation {

    @Override
    public String getHelpCommand() {
        return "help";
    }

    @Override
    public String getMessageTitle() {
        return "__Command Help__";
    }

    @Override
    public String getEntryFormat() {
        return "**%s%s** %s";
    }

    @Override
    public String getSpecificFormat() {
        return "**%s%s**\n%s (_%s_)";
    }

    @Override
    public String getNotFoundMessage() {
        return "The command %s could not be found!";
    }
}