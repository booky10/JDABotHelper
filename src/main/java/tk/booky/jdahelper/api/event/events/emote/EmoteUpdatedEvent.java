package tk.booky.jdahelper.api.event.events.emote;
// Created by booky10 in JDABotHelper (22:00 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Emote;
import tk.booky.jdahelper.api.event.api.IUpdatedEvent;

public class EmoteUpdatedEvent<T> extends EmoteEvent implements IUpdatedEvent<Emote, T> {

    protected final T previous, next;
    protected final String identifier;

    public EmoteUpdatedEvent(JDA jda, Long response, Emote emote, T previous, T next, String identifier) {
        super(jda, response, emote);

        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    @Override
    public Emote getEntity() {
        return emote;
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
        return "EmoteUpdate[" + getPropertyIdentifier() + "](" + getOldValue() + "->" + getNewValue() + ')';
    }
}