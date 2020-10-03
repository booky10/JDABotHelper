package tk.booky.jdahelper.internal.events;
// Created by booky10 in JDABotHelper (18:40 27.09.20)

import tk.booky.jdahelper.api.event.api.AbstractEventManager;
import tk.booky.jdahelper.api.event.api.Event;
import tk.booky.jdahelper.api.event.api.HandleEvent;
import tk.booky.jdahelper.api.event.api.IListener;
import tk.booky.jdahelper.utils.Pair;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class EventManager extends AbstractEventManager {

    private final List<IListener> registeredListeners = new ArrayList<>();

    @Override
    public final void callEvent(Event event) {
        List<EventData> data = new ArrayList<>();

        for (IListener listener : registeredListeners) {
            List<Pair<Method, HandleEvent>> handlers = new ArrayList<>();
            for (Method method : listener.getClass().getDeclaredMethods()) {
                method.setAccessible(true);
                for (Annotation annotation : method.getDeclaredAnnotations())
                    if (annotation.annotationType().equals(HandleEvent.class))
                        handlers.add(new Pair<>(method, (HandleEvent) annotation));
            }
            data.add(new EventData(listener, handlers));
        }

        sortDataList(data);

        for (EventData eventData : data)
            for (Pair<Method, HandleEvent> pair : eventData.getHandlers())
                try {
                    pair.getKey().invoke(eventData, event);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
    }

    private void sortDataList(List<EventData> data) {
        Comparator<Pair<Method, HandleEvent>> comparator = new PriorityComparator();
        List<EventData> dataCopy = new ArrayList<>(data);
        data.clear();

        for (EventData eventDataCopy : dataCopy) {
            eventDataCopy.getHandlers().sort(comparator);
            data.add(eventDataCopy);
        }
    }

    @Override
    public final void registerListener(IListener listener) {
        if (registeredListeners.contains(listener)) return;
        registeredListeners.add(listener);
    }

    public final void unregisterListener(IListener listener) {
        registeredListeners.remove(listener);
    }

    public final void unregisterListener(Class<? extends IListener> clazz) {
        registeredListeners.removeIf(listener -> listener.getClass().equals(clazz));
    }
}