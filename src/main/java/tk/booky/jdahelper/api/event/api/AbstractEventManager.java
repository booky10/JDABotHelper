package tk.booky.jdahelper.api.event.api;
// Created by booky10 in JDABotHelper (20:09 27.09.20)

import tk.booky.jdahelper.internal.events.EventData;

import java.util.HashMap;
import java.util.List;

public abstract class AbstractEventManager {

    public abstract void callEvent(Event event);

    public abstract void registerListener(IListener listener);
}