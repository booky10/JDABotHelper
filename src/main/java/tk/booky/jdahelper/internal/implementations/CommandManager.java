package tk.booky.jdahelper.internal.implementations;
// Created by booky10 in JDABotHelper (18:09 27.09.20)

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import tk.booky.jdahelper.api.commands.Command;
import tk.booky.jdahelper.api.commands.ICommandManager;
import tk.booky.jdahelper.internal.Helper;

import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandManager implements ICommandManager {

    private static final HashMap<String, Command> commands = new HashMap<>();

    static {
        commands.put("help", null);
        commands.put("hilfe", null);
    }

    @Override
    public void executeCommand(Message message, String command, String[] args) {
        User user = message.getAuthor();
        String processedCommand = command.toLowerCase().replace(' ', '_');

        new Thread(() -> {
            if (processedCommand.equals("help") || processedCommand.equals("hilfe"))
                sendHelpMessage(message.getTextChannel());
            else if (commands.containsKey(command.toLowerCase().replace(' ', '_')))
                commands.get(command).call(user, message, args);
            else
                sendHelpMessage(message.getTextChannel());
        }, "Command Executor [" + command + "] (" + user.getAsTag() + ")").start();
    }

    @Override
    public void registerCommand(Command command) {

    }

    @Override
    public void unregisterCommand(Command command) {

    }

    @Override
    public void sendHelpMessage(MessageChannel channel) {
        Helper.sendEmbed(channel, Color.RED, "**__Help__**", "There are the following Commands:");
    }

    @Override
    public Map<String, Command> getRegisteredCommands() {
        return Collections.unmodifiableMap(commands);
    }
}