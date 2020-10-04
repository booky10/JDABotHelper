package tk.booky.jdahelper.api.event.events.voice;
// Created by booky10 in JDABotHelper (20:12 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class VoiceChannelCreatedEvent extends VoiceChannelEvent {

    public VoiceChannelCreatedEvent(JDA jda, Long response, VoiceChannel createdChannel) {
        super(jda, response, createdChannel);
    }
}