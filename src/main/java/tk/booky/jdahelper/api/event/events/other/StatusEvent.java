package tk.booky.jdahelper.api.event.events.other;
// Created by booky10 in JDABotHelper (21:43 27.09.20)

import net.dv8tion.jda.api.JDA;
import tk.booky.jdahelper.api.event.api.Event;
import tk.booky.jdahelper.api.event.api.IUpdateEvent;

public class StatusEvent extends Event implements IUpdateEvent<JDA, JDA.Status> {

    public static final String IDENTIFIER = "status";

    protected final JDA.Status newStatus, oldStatus;

    public StatusEvent(JDA api, JDA.Status newStatus, JDA.Status oldStatus) {
        super(api);
        this.newStatus = newStatus;
        this.oldStatus = oldStatus;
    }

    public JDA.Status getNewStatus() {
        return newStatus;
    }

    public JDA.Status getOldStatus() {
        return oldStatus;
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
    public JDA.Status getOldValue() {
        return oldStatus;
    }

    @Override
    public JDA.Status getNewValue() {
        return newStatus;
    }

    @Override
    public String toString() {
        return "StatusUpdate(" + getOldStatus() + "->" + getNewStatus() + ')';
    }
}