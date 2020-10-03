package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:56 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class TextChannelDeletedEvent extends TextChannelEvent{

    public TextChannelDeletedEvent(JDA jda, Long response, TextChannel channel) {
        super(jda, response, channel);
    }
}