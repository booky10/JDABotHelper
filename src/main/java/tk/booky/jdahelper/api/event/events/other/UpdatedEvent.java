package tk.booky.jdahelper.api.event.events.other;
// Created by booky10 in JDABotHelper (21:36 27.09.20)

import net.dv8tion.jda.api.JDA;
import tk.booky.jdahelper.api.event.api.Event;
import tk.booky.jdahelper.api.event.api.IUpdatedEvent;

public class UpdatedEvent<E, T> extends Event implements IUpdatedEvent<E, T> {

    private final String identifier;
    private final E entity;
    private final T oldValue, newValue;

    public UpdatedEvent(JDA jda, Long response, String identifier, E entity, T oldValue, T newValue) {
        super(jda, response);

        this.identifier = identifier;
        this.entity = entity;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @Override
    public String getPropertyIdentifier() {
        return identifier;
    }

    @Override
    public E getEntity() {
        return entity;
    }

    @Override
    public T getOldValue() {
        return oldValue;
    }

    @Override
    public T getNewValue() {
        return newValue;
    }
}