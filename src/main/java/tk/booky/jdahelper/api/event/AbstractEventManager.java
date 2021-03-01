package tk.booky.jdahelper.api.event;
// Created by booky10 in JDABotHelper (20:09 27.09.20)

import net.dv8tion.jda.api.events.Event;

public abstract class AbstractEventManager {

    public abstract void callEvent(Event event);

    public abstract void registerListener(IListener listener);
}