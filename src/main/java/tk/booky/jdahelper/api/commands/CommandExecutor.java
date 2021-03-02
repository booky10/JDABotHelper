package tk.booky.jdahelper.api.commands;
// Created by booky10 in JDABotHelper (21:22 02.03.21)

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public interface CommandExecutor {

    void execute(TextChannel channel, Message message, Member member, String command, String[] args);
}