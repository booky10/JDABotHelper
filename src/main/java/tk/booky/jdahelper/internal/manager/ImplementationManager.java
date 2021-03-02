package tk.booky.jdahelper.internal.manager;
// Created by booky10 in JDABotHelper (16:55 02.03.21)

import tk.booky.jdahelper.api.manager.IImplementationManager;
import tk.booky.jdahelper.internal.events.Listener;

public class ImplementationManager implements IImplementationManager {

    private static final Listener listener = new Listener();
    private static final CommandManager commandManager = new CommandManager();
    private static final LanguageManager languageManager = new LanguageManager();
    private static final EventManager eventManager = new EventManager();
    private static final ConfigurationManager configurationManager = new ConfigurationManager();

    public ImplementationManager() {
    }

    @Override
    public Listener getListener() {
        return listener;
    }

    @Override
    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public LanguageManager getLanguageManager() {
        return languageManager;
    }

    @Override
    public EventManager getEventManager() {
        return eventManager;
    }

    @Override
    public ConfigurationManager getConfigurationManager() {
        return configurationManager;
    }
}