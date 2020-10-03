package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (18:12 03.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;

public class ReactionRemoveAllEvent extends MessageEvent{

    public ReactionRemoveAllEvent(JDA api, Long responseNumber, Long messageId, MessageChannel channel) {
        super(api, responseNumber, messageId, channel);
    }
}