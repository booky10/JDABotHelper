package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (21:56 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PrivateChannel;

public class DirectMessageEvent extends DirectEvent {

    protected final Long messageID;

    public DirectMessageEvent(JDA jda, Long response, Long messageID, PrivateChannel channel) {
        super(jda, response, channel);

        this.messageID = messageID;
    }

    public Long getMessageIDLong() {
        return messageID;
    }

    public String getMessageID() {
        return Long.toUnsignedString(getMessageIDLong());
    }
}