package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:57 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import tk.booky.jdahelper.api.event.api.IUpdatedEvent;

public class TextChannelUpdatedEvent<T> extends TextChannelEvent implements IUpdatedEvent<TextChannel, T> {

    protected final T previous, next;
    protected final String identifier;

    public TextChannelUpdatedEvent(JDA jda, Long response, TextChannel channel, T previous, T next, String identifier) {
        super(jda, response, channel);

        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    @Override
    public TextChannel getEntity() {
        return getChannel();
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
        return "TextChannelUpdate[" + getPropertyIdentifier() + "](" + getOldValue() + "->" + getNewValue() + ')';
    }
}