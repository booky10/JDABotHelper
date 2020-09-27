package tk.booky.jdahelper.internal.events;
// Created by booky10 in JDABotHelper (20:04 27.09.20)

import tk.booky.jdahelper.api.event.api.HandleEvent;
import tk.booky.jdahelper.api.event.api.IListener;
import tk.booky.jdahelper.utils.Pair;

import java.lang.reflect.Method;
import java.util.List;

public final class EventData {

    private final IListener listener;
    private final List<Pair<Method, HandleEvent>> handlers;

    public EventData(IListener listener, List<Pair<Method, HandleEvent>> handlers) {
        this.listener = listener;
        this.handlers = handlers;
    }

    public IListener getListener() {
        return listener;
    }

    public List<Pair<Method, HandleEvent>> getHandlers() {
        return handlers;
    }
}