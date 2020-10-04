package tk.booky.jdahelper.api.event.events.store;
// Created by booky10 in JDABotHelper (21:56 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StoreChannel;

public class StoreChannelCreatedEvent extends StoreChannelEvent {

    public StoreChannelCreatedEvent(JDA jda, Long response, StoreChannel createdChannel) {
        super(jda, response, createdChannel);
    }
}