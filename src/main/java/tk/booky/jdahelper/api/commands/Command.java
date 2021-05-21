package tk.booky.jdahelper.api.commands;
// Created by booky10 in JDABotHelper (18:37 27.09.20)

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    private final List<Permission> permissions = new ArrayList<>();
    private final List<String> aliases = new ArrayList<>();
    private final String label, usage;
    private CommandExecutor executor;

    public Command(@NotNull String label, @Nullable String usage) {
        this(label, usage, null, null);
    }

    public Command(@NotNull String label, @Nullable String usage, @Nullable List<String> aliases, @Nullable List<Permission> permissions) {
        this(label, usage, aliases, permissions, null);
    }

    public Command(@NotNull String label, @Nullable String usage, @Nullable List<String> aliases, @Nullable List<Permission> permissions, @Nullable CommandExecutor executor) {
        this.label = label;
        this.usage = usage;
        this.executor = executor;

        if (aliases != null) this.aliases.addAll(aliases);
        if (permissions != null) this.permissions.addAll(permissions);
    }

    @NotNull
    public String getLabel() {
        return label;
    }

    @Nullable
    public String getUsage() {
        return usage;
    }

    public boolean hasUsage() {
        return usage != null;
    }

    @NotNull
    public List<String> getAliases() {
        return aliases;
    }

    public boolean hasAliases() {
        return aliases.size() > 0;
    }

    @NotNull
    public List<Permission> getPermissions() {
        return permissions;
    }

    public boolean hasPermissions() {
        return permissions.size() > 0;
    }

    public boolean hasPermission(@Nullable Member member) {
        return member == null || !hasPermissions() || member.hasPermission(permissions);
    }

    @Nullable
    public CommandExecutor getExecutor() {
        return executor;
    }

    public boolean hasExecutor() {
        return executor != null;
    }

    @NotNull
    public Command setExecutor(@Nullable CommandExecutor executor) {
        this.executor = executor;
        return this;
    }

    @NotNull
    public Command withAlias(@NotNull String alias) {
        aliases.add(alias);
        return this;
    }

    @NotNull
    public Command withPermission(@NotNull Permission permission) {
        permissions.add(permission);
        return this;
    }

    public final void executeCommand(@NotNull TextChannel channel, @NotNull Message message, @NotNull Member member, @NotNull String command, @NotNull String[] args) {
        if (executor == null || (permissions.size() > 0 && !member.hasPermission(permissions))) return;
        executor.execute(channel, message, member, command, args);
    }
}