package tk.booky.jdahelper.api.event.events.voice;
// Created by booky10 in JDABotHelper (20:10 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class VoiceChannelDeletedEvent extends VoiceChannelEvent {

    public VoiceChannelDeletedEvent(JDA jda, Long response, VoiceChannel channel) {
        super(jda, response, channel);
    }
}