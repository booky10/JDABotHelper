package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (21:53 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;

public class MessageDeletedEvent extends MessageEvent {

    public MessageDeletedEvent(JDA api, Long responseNumber, Long messageID, MessageChannel channel) {
        super(api, responseNumber, messageID, channel);
    }
}