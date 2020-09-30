package tk.booky.jdahelper.api.event.api;
// Created by booky10 in JDABotHelper (22:23 30.09.20)

public interface UpdateEvent<E, T> {

    default Class<E> getEntityType() {
        return (Class<E>) getEntity().getClass();
    }

    String getPropertyIdentifier();

    E getEntity();

    T getOldValue();

    T getNewValue();
}