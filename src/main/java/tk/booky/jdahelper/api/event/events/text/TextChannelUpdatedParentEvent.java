package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:58 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.TextChannel;

public class TextChannelUpdatedParentEvent extends TextChannelUpdatedEvent<Category> {

    public static final String IDENTIFIER = "parent";

    public TextChannelUpdatedParentEvent(JDA jda, Long response, TextChannel channel, Category oldParent) {
        super(jda, response, channel, oldParent, channel.getParent(), IDENTIFIER);
    }

    public Category getOldParent() {
        return getOldValue();
    }

    public Category getNewParent() {
        return getNewValue();
    }
}