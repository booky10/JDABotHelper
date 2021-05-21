package tk.booky.jdahelper.internal.manager;
// Created by booky10 in JDABotHelper (18:09 27.09.20)

import net.dv8tion.jda.api.entities.*;
import org.jetbrains.annotations.Nullable;
import tk.booky.jdahelper.api.IConfiguration;
import tk.booky.jdahelper.api.commands.Command;
import tk.booky.jdahelper.api.commands.IHelpTranslation;
import tk.booky.jdahelper.api.exceptions.api.CommandException;
import tk.booky.jdahelper.api.manager.ICommandManager;
import tk.booky.jdahelper.api.utils.JDAHelper;
import tk.booky.jdahelper.internal.fallback.FallbackHelpTranslation;

import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
                if (message.getChannelType().equals(ChannelType.TEXT)) {
                    TextChannel channel = (TextChannel) message.getChannel();

                    if (trimmedCommand.equals(trimCommand(JDAHelper.getLanguageManager().getLanguageProvider(channel.getGuild()).getHelpTranslation().getHelpCommand()))) {
                        sendHelpMessage(channel, null);
                    } else {
                        Command commandObject = resolveCommand(trimmedCommand);
                        if (commandObject != null) {
                            if (Objects.requireNonNull(message.getGuild().getMemberById(message.getAuthor().getId())).hasPermission(commandObject.getPermissions())) {
                                commandObject.execute(channel, message, channel.getGuild().getMember(message.getAuthor()), command, args);
                            }
                        }
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
        String trimmedCommand = trimCommand(command.getCommand());
        commands.put(trimmedCommand, command);
        command.getAlias().forEach(alias -> CommandManager.alias.put(trimCommand(alias), trimmedCommand));
    }

    @Override
    public void unregisterCommand(Command command) {
        String trimmedCommand = trimCommand(command.getCommand());
        commands.remove(trimmedCommand);
        alias.forEach((alias, originalCommand) -> {
            if (!originalCommand.equals(trimmedCommand)) return;
            CommandManager.alias.remove(alias);
        });
    }

    @Override
    public Message sendHelpMessage(MessageChannel channel, @Nullable String command) {
        GuildChannel guildChannel = channel.getType().isGuild() ? (GuildChannel) channel : null;
        IHelpTranslation helpTranslation = channel.getType().isGuild() ? JDAHelper.getLanguageManager().getLanguageProvider(((GuildChannel) channel).getGuild()).getHelpTranslation() : new FallbackHelpTranslation() {
        };

        String body;
        if (command == null) {
            body = getRegisteredCommands().entrySet().stream().map(entry -> String.format(helpTranslation.getEntryFormat(), getPrefix(guildChannel == null ? null : guildChannel.getGuild()), entry.getKey(), entry.getValue().getUsage())).collect(Collectors.joining("\n"));
        } else {
            command = trimCommand(command);
            Command resolved = resolveCommand(command);
            body = String.format(helpTranslation.getEntryFormat(), getPrefix(guildChannel == null ? null : guildChannel.getGuild()), command, resolved.getUsage());
        }

        return JDAHelper.sendEmbed(channel, Color.YELLOW, helpTranslation.getMessageTitle(), body);
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