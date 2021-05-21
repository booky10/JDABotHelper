package tk.booky.jdahelper.api.commands;
// Created by booky10 in JDABotHelper (21:22 02.03.21)

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.NotNull;

public interface CommandExecutor {

    void execute(@NotNull TextChannel channel, @NotNull Message message, @NotNull Member member, @NotNull String command, @NotNull String[] args);
}