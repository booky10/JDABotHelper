package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (13:31 04.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import tk.booky.jdahelper.api.event.api.IUpdatedEvent;

public class UserUpdatedEvent<T> extends UserEvent implements IUpdatedEvent<User, T> {

    protected final T previous, next;
    protected final String identifier;

    public UserUpdatedEvent(JDA jda, Long response, User user, T previous, T next, String identifier) {
        super(jda, response, user);

        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    @Override
    public User getEntity() {
        return getUser();
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
        return "UserUpdate[" + getPropertyIdentifier() + "](" + getOldValue() + "->" + getNewValue() + ')';
    }
}