package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:57 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import tk.booky.jdahelper.api.event.api.Event;

public class TextChannelEvent extends Event {

    private final TextChannel channel;

    public TextChannelEvent(JDA jda, Long response, TextChannel channel) {
        super(jda, response);
        this.channel = channel;
    }

    public TextChannel getChannel() {
        return channel;
    }

    public Guild getGuild() {
        return channel.getGuild();
    }
}