package tk.booky.jdahelper.api.manager;
// Created by booky10 in JDABotHelper (16:56 02.03.21)

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public interface IImplementationManager {

    ListenerAdapter getListener();

    ICommandManager getCommandManager();

    ILanguageManager getLanguageManager();

    IEventManager getEventManager();
}