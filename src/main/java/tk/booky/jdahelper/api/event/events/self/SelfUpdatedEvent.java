package tk.booky.jdahelper.api.event.events.self;
// Created by booky10 in JDABotHelper (21:57 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.SelfUser;
import tk.booky.jdahelper.api.event.api.Event;
import tk.booky.jdahelper.api.event.api.IUpdateEvent;

public class SelfUpdatedEvent<T> extends Event implements IUpdateEvent<SelfUser, T> {

    protected final T previous, next;
    protected final String identifier;

    public SelfUpdatedEvent(JDA jda, Long response, T previous, T next, String identifier) {
        super(jda, response);
        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    public SelfUser getSelfUser() {
        return getJDA().getSelfUser();
    }

    @Override
    public SelfUser getEntity() {
        return getSelfUser();
    }

    @Override
    public String getPropertyIdentifier() {
        return identifier;
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
        return "SelfUserUpdate[" + getPropertyIdentifier() + "](" + getOldValue() + "->" + getNewValue() + ')';
    }
}