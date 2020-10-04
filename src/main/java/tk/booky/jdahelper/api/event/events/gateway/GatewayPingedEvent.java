package tk.booky.jdahelper.api.event.events.gateway;
// Created by booky10 in JDABotHelper (21:41 27.09.20)

import net.dv8tion.jda.api.JDA;
import tk.booky.jdahelper.api.event.api.Event;
import tk.booky.jdahelper.api.event.api.IUpdatedEvent;

public class GatewayPingedEvent extends Event implements IUpdatedEvent<JDA, Long> {

    public static final String IDENTIFIER = "gateway-ping";
    protected final Long next, previous;

    public GatewayPingedEvent(JDA jda, long old) {
        super(jda);

        next = jda.getGatewayPing();
        previous = old;
    }

    public Long getNewPing() {
        return getNewValue();
    }

    public Long getOldPing() {
        return getOldValue();
    }

    @Override
    public String getPropertyIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public JDA getEntity() {
        return getJDA();
    }

    @Override
    public Long getOldValue() {
        return previous;
    }

    @Override
    public Long getNewValue() {
        return next;
    }

    @Override
    public String toString() {
        return "GatewayUpdate[ping](" + getOldValue() + "->" + getNewValue() + ')';
    }
}