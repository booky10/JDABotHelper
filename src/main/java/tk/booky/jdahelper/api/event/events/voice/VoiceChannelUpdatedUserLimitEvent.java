package tk.booky.jdahelper.api.event.events.voice;
// Created by booky10 in JDABotHelper (20:11 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class VoiceChannelUpdatedUserLimitEvent extends VoiceChannelUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "userlimit";

    public VoiceChannelUpdatedUserLimitEvent(JDA jda, Long response, VoiceChannel channel, Integer oldLimit) {
        super(jda, response, channel, oldLimit, channel.getUserLimit(), IDENTIFIER);
    }

    public Integer getOldLimit() {
        return getOldValue();
    }

    public Integer getNewLimit() {
        return getNewValue();
    }
}