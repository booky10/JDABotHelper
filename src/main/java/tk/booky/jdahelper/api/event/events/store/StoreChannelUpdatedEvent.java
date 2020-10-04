package tk.booky.jdahelper.api.event.events.store;
// Created by booky10 in JDABotHelper (21:57 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StoreChannel;
import tk.booky.jdahelper.api.event.api.IUpdatedEvent;

public class StoreChannelUpdatedEvent<T> extends StoreChannelEvent implements IUpdatedEvent<StoreChannel, T> {

    protected final T previous, next;
    protected final String identifier;

    public StoreChannelUpdatedEvent(JDA jda, Long response, StoreChannel channel, T previous, T next, String identifier) {
        super(jda, response, channel);

        this.previous = previous;
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
        return previous;
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