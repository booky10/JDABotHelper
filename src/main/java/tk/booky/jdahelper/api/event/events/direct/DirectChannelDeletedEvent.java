package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (20:14 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PrivateChannel;

public class DirectChannelDeletedEvent extends DirectEvent {

    public DirectChannelDeletedEvent(JDA jda, Long response, PrivateChannel channel) {
        super(jda, response, channel);
    }
}