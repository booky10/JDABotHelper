package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (21:52 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PrivateChannel;

public class DirectMessageDeletedEvent extends DirectMessageEvent {

    public DirectMessageDeletedEvent(JDA jda, Long response, Long messageID, PrivateChannel channel) {
        super(jda, response, messageID, channel);
    }
}