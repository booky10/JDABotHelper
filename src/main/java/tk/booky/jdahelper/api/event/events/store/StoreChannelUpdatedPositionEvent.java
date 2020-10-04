package tk.booky.jdahelper.api.event.events.store;
// Created by booky10 in JDABotHelper (21:56 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StoreChannel;

public class StoreChannelUpdatedPositionEvent extends StoreChannelUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "position";

    public StoreChannelUpdatedPositionEvent(JDA jda, Long response, StoreChannel channel, Integer oldPosition) {
        super(jda, response, channel, oldPosition, channel.getPositionRaw(), IDENTIFIER);
    }

    public Integer getOldPosition() {
        return getOldValue();
    }

    public Integer getNewPosition() {
        return getNewValue();
    }
}