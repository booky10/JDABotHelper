package tk.booky.jdahelper.internal.events;
// Created by booky10 in JDABotHelper (21:18 27.09.20)

import tk.booky.jdahelper.api.event.api.HandleEvent;
import tk.booky.jdahelper.utils.Pair;

import java.lang.reflect.Method;
import java.util.Comparator;

public final class PriorityComparator implements Comparator<Pair<Method, HandleEvent>> {

    @Override
    public int compare(Pair<Method, HandleEvent> entry1, Pair<Method, HandleEvent> entry2) {
        return entry1.getValue().priority().getPriority().compareTo(entry2.getValue().priority().getPriority());
    }
}