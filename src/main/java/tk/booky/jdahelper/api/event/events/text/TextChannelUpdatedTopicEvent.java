package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:57 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class TextChannelUpdatedTopicEvent extends TextChannelUpdatedEvent<String> {

    public static final String IDENTIFIER = "topic";

    public TextChannelUpdatedTopicEvent(JDA jda, Long response, TextChannel channel, String previous, String next, String identifier) {
        super(jda, response, channel, previous, channel.getTopic(), IDENTIFIER);
    }

    public String getOldTopic() {
        return getOldValue();
    }

    public String getNewTopic() {
        return getNewValue();
    }
}