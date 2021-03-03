package tk.booky.jdahelper.api.events;
// Created by booky10 in JDABotHelper (18:20 03.03.21)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

public class GuildCommandReceivedEvent extends GuildMessageReceivedEvent {

    private final String command;
    private final String[] args;
    private final boolean resolved;

    public GuildCommandReceivedEvent(@NotNull JDA api, long responseNumber, @NotNull Message message, String command, String[] args, boolean resolved) {
        super(api, responseNumber, message);
        this.command = command;
        this.args = args;
        this.resolved = resolved;
    }

    public String getCommand() {
        return command;
    }

    public String[] getArguments() {
        return args;
    }

    public boolean isResolved() {
        return resolved;
    }
}