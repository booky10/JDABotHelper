package tk.booky.jdahelper.api.event.events.voice;
// Created by booky10 in JDABotHelper (14:02 04.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.VoiceChannel;
import tk.booky.jdahelper.api.event.api.Event;

public class VoiceChannelEvent extends Event {

    protected final VoiceChannel channel;

    public VoiceChannelEvent(JDA jda, Long response, VoiceChannel channel) {
        super(jda, response);
        this.channel = channel;
    }

    public VoiceChannel getChannel() {
        return channel;
    }

    public Guild getGuild() {
        return channel.getGuild();
    }
}