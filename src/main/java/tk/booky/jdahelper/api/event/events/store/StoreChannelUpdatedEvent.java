package tk.booky.jdahelper.api.event.events.store;
// Created by booky10 in JDABotHelper (21:57 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StoreChannel;
import tk.booky.jdahelper.api.event.api.IUpdateEvent;

public class StoreChannelUpdatedEvent<T> extends StoreChannelEvent implements IUpdateEvent<StoreChannel, T> {

    protected final T prev, next;
    protected final String identifier;

    public StoreChannelUpdatedEvent(JDA jda, Long response, StoreChannel channel, T prev, T next, String identifier) {
        super(jda, response, channel);
        this.prev = prev;
        this.next = next;
        this.identifier = identifier;
    }

    @Override
    public String getPropertyIdentifier() {
        return identifier;
    }

    @Override
    public StoreChannel getEntity() {
        return channel;
    }

    @Override
    public T getOldValue() {
        return prev;
    }

    @Override
    public T getNewValue() {
        return next;
    }

    @Override
    public String toString() {
        return "StoreChannelUpdate[" + getPropertyIdentifier() + "](" + getOldValue() + "->" + getNewValue() + ')';
    }
}