package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (21:53 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import tk.booky.jdahelper.api.event.api.Event;

import java.util.Collections;
import java.util.List;

public class MessagesPurgedEvent extends Event {

    protected final TextChannel channel;
    protected final List<String> messageIDs;

    public MessagesPurgedEvent(JDA jda, Long response, TextChannel channel, List<String> messageIDs) {
        super(jda, response);
        this.channel = channel;
        this.messageIDs = Collections.unmodifiableList(messageIDs);
    }

    public TextChannel getChannel() {
        return channel;
    }

    public List<String> getMessageIDs() {
        return messageIDs;
    }

    public Guild getGuild() {
        return channel.getGuild();
    }
}