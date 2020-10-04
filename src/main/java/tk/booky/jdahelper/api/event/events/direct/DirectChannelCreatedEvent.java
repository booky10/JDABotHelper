package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (20:14 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PrivateChannel;

public class DirectChannelCreatedEvent extends DirectEvent {

    public DirectChannelCreatedEvent(JDA jda, PrivateChannel channel) {
        super(jda, channel);
    }
}