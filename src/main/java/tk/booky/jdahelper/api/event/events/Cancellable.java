package tk.booky.jdahelper.api.event.events;
// Created by booky10 in JDABotHelper (20:06 27.09.20)

public interface Cancellable {

    Boolean isCancelled();

    void setCancelled(Boolean cancelled);
}