package tk.booky.jdahelper.api.event.events.voice;
// Created by booky10 in JDABotHelper (20:11 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class VoiceChannelUpdatedNameEvent extends VoiceChannelUpdatedEvent<String> {

    public static final String IDENTIFIER = "name";

    public VoiceChannelUpdatedNameEvent(JDA jda, Long response, VoiceChannel channel, String oldName) {
        super(jda, response, channel, oldName, channel.getName(), IDENTIFIER);
    }

    public String getOldName() {
        return getOldValue();
    }

    public String getNewName() {
        return getNewValue();
    }
}