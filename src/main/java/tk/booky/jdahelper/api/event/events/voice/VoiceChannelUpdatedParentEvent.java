package tk.booky.jdahelper.api.event.events.voice;
// Created by booky10 in JDABotHelper (20:12 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class VoiceChannelUpdatedParentEvent extends VoiceChannelUpdatedEvent<Category> {

    public static final String IDENTIFIER = "parent";

    public VoiceChannelUpdatedParentEvent(JDA jda, Long response, VoiceChannel channel, Category oldParent) {
        super(jda, response, channel, oldParent, channel.getParent(), IDENTIFIER);
    }

    public Category getOldParent() {
        return getOldValue();
    }

    public Category getNewParent() {
        return getNewValue();
    }
}