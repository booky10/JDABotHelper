package tk.booky.jdahelper.internal.manager;
// Created by booky10 in JDABotHelper (18:09 27.09.20)

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.Nullable;
import tk.booky.jdahelper.api.commands.Command;
import tk.booky.jdahelper.api.manager.ICommandManager;
import tk.booky.jdahelper.api.utils.JDAHelper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandManager implements ICommandManager {

    private static final HashMap<String, Command> commands = new HashMap<>();
    private static final HashMap<String, String> alias = new HashMap<>();

    private static String trimCommand(String command) {
        return command.trim().toLowerCase().replace(' ', '_');
    }

    @Override
    public void executeCommand(Message message, String command, String[] args) {
        String trimmedCommand = trimCommand(command);

        new Thread(() -> {
            if (message.getChannelType().equals(ChannelType.TEXT)) {
                TextChannel channel = (TextChannel) message.getChannel();

                if (trimmedCommand.equals(trimCommand(JDAHelper.getLanguageManager().getLanguageProvider(channel.getGuild()).getHelpTranslation().getHelpCommand()))) {
                    sendHelpMessage(channel, null);
                } else {
                    String alias = CommandManager.alias.get(trimmedCommand);
                    Command commandObject = commands.get(alias == null ? trimmedCommand : alias);

                    if (commandObject != null) {
                        commandObject.execute(channel, message, channel.getGuild().getMember(message.getAuthor()), command, args);
                    }
                }
            }
        }, "Command Executor [" + command + "] (" + message.getAuthor().getAsTag() + ")").start();
    }

    @Override
    public void registerCommand(Command command) {
        String trimmedCommand = trimCommand(command.getCommand());
        commands.put(trimmedCommand, command);
        command.getAlias().forEach(alias -> CommandManager.alias.put(trimCommand(alias), trimmedCommand));
    }

    @Override
    public void unregisterCommand(Command command) {
        commands.remove(trimCommand(command.getCommand()));
        alias.forEach((alias, originalCommand) -> {
            if (originalCommand.equalsIgnoreCase(trimCommand(command.getCommand()))) {
                CommandManager.alias.remove(alias);
            }
        });
    }

    @Override
    public void sendHelpMessage(MessageChannel channel, @Nullable String command) {
        // TODO: send translated help message
    }

    @Override
    public Map<String, Command> getRegisteredCommands() {
        return Collections.unmodifiableMap(commands);
    }

    @Override
    public Map<String, String> getAliases() {
        return Collections.unmodifiableMap(alias);
    }
}