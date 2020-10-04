package tk.booky.jdahelper.api.event.api;
// Created by booky10 in JDABotHelper (20:09 27.09.20)

public abstract class AbstractEventManager {

    public abstract void callEvent(Event event);

    public abstract void registerListener(IListener listener);
}