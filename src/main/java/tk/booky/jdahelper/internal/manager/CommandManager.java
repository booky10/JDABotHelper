package tk.booky.jdahelper.internal.manager;
// Created by booky10 in JDABotHelper (18:09 27.09.20)

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import org.jetbrains.annotations.Nullable;
import tk.booky.jdahelper.api.IConfiguration;
import tk.booky.jdahelper.api.commands.Command;
import tk.booky.jdahelper.api.commands.IHelpTranslation;
import tk.booky.jdahelper.api.exceptions.api.CommandException;
import tk.booky.jdahelper.api.manager.ICommandManager;
import tk.booky.jdahelper.api.provider.ILanguageProvider;
import tk.booky.jdahelper.api.utils.JDAHelper;
import tk.booky.jdahelper.internal.fallback.FallbackHelpTranslation;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.*;

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
            try {
                if (!message.getChannelType().equals(ChannelType.TEXT)) return;

                TextChannel channel = (TextChannel) message.getChannel();
                ILanguageProvider provider = JDAHelper.getLanguageManager().getLanguageProvider(channel.getGuild());

                boolean help = trimmedCommand.equals(trimCommand(provider.getHelpTranslation().getHelpCommand()));

                if (help && args.length < 1) {
                    sendHelpMessage(channel, (String) null);
                } else {
                    Command commandObject = resolveCommand(trimmedCommand);
                    if (commandObject != null && help) {
                        sendHelpMessage(channel, commandObject);
                    } else if (commandObject != null) {
                        Member member = message.getGuild().getMember(message.getAuthor());
                        if (member == null) return;

                        commandObject.executeCommand(channel, message, member, command, args);
                    } else if (help) {
                        sendHelpMessage(channel, (String) null);
                    }
                }
            } catch (Throwable throwable) {
                CommandException commandException = new CommandException(throwable);
                commandException.printStackTrace(System.out);

                try (StringWriter writer = new StringWriter(); PrintWriter printer = new PrintWriter(writer)) {
                    commandException.printStackTrace(printer);
                    String stacktrace = writer.toString().replace("\t", "  ");
                    if (stacktrace.length() > 2048) stacktrace = stacktrace.substring(0, 2048);

                    EmbedBuilder builder = new EmbedBuilder();
                    builder.setColor(Color.RED);
                    builder.setTimestamp(new Date().toInstant());
                    builder.setDescription(stacktrace);

                    message.getChannel().sendMessage(builder.build()).complete();
                } catch (IOException exception) {
                    throw new Error(exception);
                }
            }
        }, "Command Executor [" + command + "] (" + message.getAuthor().getAsTag() + ")").start();
    }

    @Override
    public void registerCommand(Command command) {
        String trimmedCommand = trimCommand(command.getLabel());
        commands.put(trimmedCommand, command);
        command.getAliases().forEach(alias -> CommandManager.alias.put(trimCommand(alias), trimmedCommand));
    }

    @Override
    public void unregisterCommand(Command command) {
        String trimmedCommand = trimCommand(command.getLabel());
        commands.remove(trimmedCommand);
        alias.forEach((alias, originalCommand) -> {
            if (!originalCommand.equals(trimmedCommand)) return;
            CommandManager.alias.remove(alias);
        });
    }

    @Override
    public Message sendHelpMessage(MessageChannel channel, @Nullable Command command, @Nullable Member member) {
        boolean isGuild = channel.getType().isGuild();
        GuildChannel guildChannel = isGuild ? (GuildChannel) channel : null;

        ILanguageProvider provider = isGuild ? JDAHelper.getLanguageManager().getLanguageProvider(guildChannel.getGuild()) : null;
        IHelpTranslation translation = isGuild ? provider.getHelpTranslation() : FallbackHelpTranslation.FALLBACK;

        List<String> commands = new ArrayList<>();
        String prefix = getPrefix(isGuild ? guildChannel.getGuild() : null);

        if (command == null || !command.hasPermission(member)) {
            getRegisteredCommands()
                    .values()
                    .stream()
                    .filter(object -> object.hasPermission(member))
                    .forEach(object -> commands.add(String.format(prefix, object.getLabel(), object.hasUsage() ? object.getUsage() : "")));
        } else {
            commands.add(String.format(prefix, command.getLabel(), command.hasUsage() ? command.getUsage() : ""));
        }

        return JDAHelper.sendEmbed(channel, Color.YELLOW, translation.getMessageTitle(), String.join("\n", commands));
    }

    @Override
    public Message sendHelpMessage(MessageChannel channel, @Nullable Command command) {
        return sendHelpMessage(channel, command, null);
    }

    @Override
    public Message sendHelpMessage(MessageChannel channel, @Nullable String command, @Nullable Member member) {
        return sendHelpMessage(channel, command == null ? null : resolveCommand(command), member);
    }

    @Override
    public Message sendHelpMessage(MessageChannel channel, @Nullable String command) {
        return sendHelpMessage(channel, command, null);
    }

    @Override
    public Map<String, Command> getRegisteredCommands() {
        return Collections.unmodifiableMap(commands);
    }

    @Override
    public Map<String, String> getAliases() {
        return Collections.unmodifiableMap(alias);
    }

    @Override
    public Command resolveCommand(String command) {
        command = trimCommand(command);
        String alias = CommandManager.alias.get(command);
        return commands.get(alias == null ? command : alias);
    }

    @Override
    public String getPrefix(Guild guild) {
        return guild == null ? "!" : JDAHelper.getConfigurationManager().getConfiguration(guild).getString("prefix", "!");
    }

    @Override
    public void setPrefix(Guild guild, String prefix) {
        IConfiguration<?> configuration = JDAHelper.getConfigurationManager().getConfiguration(guild);
        configuration.set("prefix", prefix.trim());
        configuration.save(guild);
    }

    @Override
    public boolean existsCommand(String command) {
        command = trimCommand(command);
        return commands.containsKey(command) || alias.containsKey(command);
    }
}