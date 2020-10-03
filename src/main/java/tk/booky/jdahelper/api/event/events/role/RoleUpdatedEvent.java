package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (22:00 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Role;
import tk.booky.jdahelper.api.event.api.IUpdateEvent;

public class RoleUpdatedEvent<T> extends RoleEvent implements IUpdateEvent<Role, T> {

    protected final T previous;
    protected final T next;
    protected final String identifier;

    public RoleUpdatedEvent(JDA jda, Long response, Role role, T previous, T next, String identifier) {
        super(jda, response, role);
        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    @Override
    public Role getEntity() {
        return role;
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

    public String toString() {
        return "RoleUpdate[" + getPropertyIdentifier() + "](" + getOldValue() + "->" + getNewValue() + ")";
    }
}