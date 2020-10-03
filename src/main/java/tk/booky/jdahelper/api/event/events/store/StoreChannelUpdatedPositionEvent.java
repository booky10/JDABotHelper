package tk.booky.jdahelper.api.event.events.store;
// Created by booky10 in JDABotHelper (21:56 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StoreChannel;

public class StoreChannelUpdatedPositionEvent extends StoreChannelUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "position";

    public StoreChannelUpdatedPositionEvent(JDA jda, Long response, StoreChannel channel, Integer prev, Integer next, String identifier) {
        super(jda, response, channel, prev, next, identifier);
    }

    /**
     * The old position
     *
     * @return The old position
     */
    public Integer getOldPosition() {
        return getOldValue();
    }

    /**
     * The new position
     *
     * @return The new position
     */
    public Integer getNewPosition() {
        return getNewValue();
    }
}