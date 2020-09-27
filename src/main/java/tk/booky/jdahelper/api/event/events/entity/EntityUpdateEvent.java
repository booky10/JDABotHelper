package tk.booky.jdahelper.api.event.events.entity;
// Created by booky10 in JDABotHelper (21:36 27.09.20)

import net.dv8tion.jda.api.JDA;
import tk.booky.jdahelper.api.event.events.Event;

public class EntityUpdateEvent<E, T> extends Event {

    private final String identifier;
    private final E entity;
    private final T oldValue, newValue;

    public EntityUpdateEvent(JDA jda, Long response, String identifier, E entity, T oldValue, T newValue) {
        super(jda, response);
        this.identifier = identifier;
        this.entity = entity;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getIdentifier() {
        return identifier;
    }

    public E getEntity() {
        return entity;
    }

    public T getOldValue() {
        return oldValue;
    }

    public T getNewValue() {
        return newValue;
    }

    @SuppressWarnings("unchecked")
    public Class<E> getEntityClass() {
        return (Class<E>) entity.getClass();
    }
}