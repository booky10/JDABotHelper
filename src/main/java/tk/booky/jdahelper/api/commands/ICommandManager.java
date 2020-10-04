package tk.booky.jdahelper.api.commands;
// Created by booky10 in JDABotHelper (18:02 04.10.20)

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.Map;

public interface ICommandManager {

    void executeCommand(Message message, String command, String[] args);

    void registerCommand(Command command);

    void unregisterCommand(Command command);

    void sendHelpMessage(MessageChannel channel);

    Map<String, Command> getRegisteredCommands();
}