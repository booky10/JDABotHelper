package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:56 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class TextChannelCreatedEvent extends TextChannelEvent{

    public TextChannelCreatedEvent(JDA jda, Long response, TextChannel createdChannel) {
        super(jda, response, createdChannel);
    }
}