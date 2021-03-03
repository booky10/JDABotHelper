package tk.booky.jdahelper.api.manager;
// Created by booky10 in JDABotHelper (18:02 04.10.20)

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.jetbrains.annotations.Nullable;
import tk.booky.jdahelper.api.commands.Command;

import java.util.Map;

public interface ICommandManager {

    void executeCommand(Message message, String command, String[] args);

    void registerCommand(Command command);

    void unregisterCommand(Command command);

    void sendHelpMessage(MessageChannel channel, @Nullable String command);

    Map<String, Command> getRegisteredCommands();

    Map<String, String> getAliases();

    Command resolveCommand(String command);

    String getPrefix(Guild guild);

    void setPrefix(Guild guild, String prefix);
}