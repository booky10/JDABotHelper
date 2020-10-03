package tk.booky.jdahelper.api.event.events.store;
// Created by booky10 in JDABotHelper (21:55 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StoreChannel;

public class StoreChannelDeletedEvent extends StoreChannelEvent {

    public StoreChannelDeletedEvent(JDA jda, Long response, StoreChannel channel) {
        super(jda, response, channel);
    }
}