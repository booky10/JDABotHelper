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
        return getChannel().getGuild();
    }

    public String getChannelID() {
        return Long.toUnsignedString(getChannelIDLong());
    }

    public Long getChannelIDLong() {
        return getChannel().getIdLong();
    }

    public String getGuildID() {
        return Long.toUnsignedString(getGuildIDLong());
    }

    public Long getGuildIDLong() {
        return getGuild().getIdLong();
    }
}