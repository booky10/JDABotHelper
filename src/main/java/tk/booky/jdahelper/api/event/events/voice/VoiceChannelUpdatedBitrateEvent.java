package tk.booky.jdahelper.api.event.events.voice;
// Created by booky10 in JDABotHelper (20:11 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class VoiceChannelUpdatedBitrateEvent extends VoiceChannelUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "bitrate";

    public VoiceChannelUpdatedBitrateEvent(JDA jda, Long response, VoiceChannel channel, Integer oldBitrate) {
        super(jda, response, channel, oldBitrate, channel.getBitrate(), IDENTIFIER);
    }

    public Integer getOldBitrate() {
        return getOldValue();
    }

    public Integer getNewBitrate() {
        return getNewValue();
    }
}