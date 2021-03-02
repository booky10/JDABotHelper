package tk.booky.jdahelper.api.commands;
// Created by booky10 in JDABotHelper (18:37 27.09.20)

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public abstract class Command {

    private final String command;
    private final List<String> alias;
    private final List<Permission> permissions;

    private final CommandExecutor executor;

    public Command(String command, List<String> alias, List<Permission> permissions, CommandExecutor executor) {
        this.command = command;
        this.alias = alias;
        this.permissions = permissions;
        this.executor = executor;
    }

    public String getCommand() {
        return command;
    }

    public List<String> getAlias() {
        return alias;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    public final void execute(TextChannel channel, Message message, Member member, String command, String[] args) {
        getExecutor().execute(channel, message, member, command, args);
    }
}