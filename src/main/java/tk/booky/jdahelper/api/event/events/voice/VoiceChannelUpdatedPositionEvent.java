package tk.booky.jdahelper.api.event.events.voice;
// Created by booky10 in JDABotHelper (20:11 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class VoiceChannelUpdatedPositionEvent extends VoiceChannelUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "position";

    public VoiceChannelUpdatedPositionEvent(JDA jda, Long response, VoiceChannel channel, Integer oldPosition) {
        super(jda, response, channel, oldPosition, channel.getPositionRaw(), IDENTIFIER);
    }

    public Integer getOldPosition() {
        return getOldValue();
    }

    public Integer getNewPosition() {
        return getNewValue();
    }
}