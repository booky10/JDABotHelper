package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (21:56 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import tk.booky.jdahelper.api.event.api.Event;

public class DirectMessageEvent extends Event {

    protected final Long messageID;
    protected final PrivateChannel channel;

    public DirectMessageEvent(JDA jda, Long response, Long messageID, PrivateChannel channel) {
        super(jda, response);
        this.messageID = messageID;
        this.channel = channel;
    }

    public Long getMessageIDLong() {
        return messageID;
    }

    public String getMessageID() {
        return Long.toUnsignedString(messageID);
    }

    public PrivateChannel getChannel() {
        return channel;
    }

    public User getUser() {
        return channel.getUser();
    }
}