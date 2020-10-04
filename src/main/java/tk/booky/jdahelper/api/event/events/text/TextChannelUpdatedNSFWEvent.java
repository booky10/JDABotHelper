package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:57 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class TextChannelUpdatedNSFWEvent extends TextChannelUpdatedEvent<Boolean> {

    public static final String IDENTIFIER = "nsfw";

    public TextChannelUpdatedNSFWEvent(JDA jda, Long response, TextChannel channel, Boolean oldNSFW) {
        super(jda, response, channel, oldNSFW, channel.isNSFW(), IDENTIFIER);
    }
}