package tk.booky.jdahelper.api.event.events.voice;
// Created by booky10 in JDABotHelper (21:58 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.VoiceChannel;
import tk.booky.jdahelper.api.event.api.IUpdateEvent;

public class VoiceChannelUpdatedEvent<T> extends VoiceChannelEvent implements IUpdateEvent<VoiceChannel, T> {

    protected final T previous, next;
    protected final String identifier;

    public VoiceChannelUpdatedEvent(JDA jda, Long response, VoiceChannel channel, T previous, T next, String identifier) {
        super(jda, response, channel);
        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    @Override
    public VoiceChannel getEntity() {
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
        return "VoiceChannelUpdate[" + getPropertyIdentifier() + "](" + getOldValue() + "->" + getNewValue() + ')';
    }
}