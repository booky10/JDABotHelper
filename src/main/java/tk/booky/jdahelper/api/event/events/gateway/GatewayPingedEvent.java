package tk.booky.jdahelper.api.event.events.gateway;
// Created by booky10 in JDABotHelper (21:41 27.09.20)

import net.dv8tion.jda.api.JDA;
import tk.booky.jdahelper.api.event.api.Event;
import tk.booky.jdahelper.api.event.api.UpdateEvent;

public class GatewayPingedEvent extends Event implements UpdateEvent<JDA, Long> {

    public static final String IDENTIFIER = "gateway-ping";
    private final long next, prev;

    public GatewayPingedEvent(JDA jda, long old) {
        super(jda);
        next = jda.getGatewayPing();
        prev = old;
    }

    public long getNewPing() {
        return next;
    }

    public long getOldPing() {
        return prev;
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
        return prev;
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