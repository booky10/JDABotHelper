package tk.booky.jdahelper.internal.events;
// Created by booky10 in JDABotHelper (18:40 27.09.20)

import net.dv8tion.jda.api.events.Event;
import tk.booky.jdahelper.api.event.AbstractEventManager;
import tk.booky.jdahelper.api.event.HandleEvent;
import tk.booky.jdahelper.api.event.IListener;
import tk.booky.jdahelper.api.exceptions.events.EventException;
import tk.booky.jdahelper.api.exceptions.events.ListenerRegisterException;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class EventManager extends AbstractEventManager {

    private final HashMap<Method, Class<? extends Event>> registeredHandlers = new HashMap<>();
    private final HashMap<Method, IListener> listenerInstances = new HashMap<>();

    @Override
    public void callEvent(Event event) {
        registeredHandlers
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().isAssignableFrom(event.getClass()))
                .map(Map.Entry::getKey)
                .sorted(new PriorityComparator())
                .forEach(method -> invokeEventMethod(method, event));
    }

    private void invokeEventMethod(Method method, Event event) {
        try {
            method.invoke(listenerInstances.get(method), event);
        } catch (Throwable throwable) {
            new EventException(throwable).printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void registerListener(IListener listener) {
        Arrays.stream(listener.getClass().getDeclaredMethods()).forEach(method -> {
            if (Arrays.stream(method.getDeclaredAnnotations()).noneMatch(annotation -> annotation instanceof HandleEvent)) return;
            if (method.getParameterCount() != 1) return;

            try {
                method.setAccessible(true);
                registeredHandlers.put(method, (Class<? extends Event>) method.getParameterTypes()[0]);
                listenerInstances.put(method, listener);
            } catch (Throwable throwable) {
                throw new ListenerRegisterException(throwable);
            }
        });
    }

    public final void unregisterListener(IListener listener) {
        unregisterListener(listener.getClass());
    }

    public final void unregisterListener(Class<? extends IListener> clazz) {
        registeredHandlers
                .keySet()
                .stream()
                .filter(method -> method.getDeclaringClass().equals(clazz))
                .forEach(registeredHandlers::remove);
    }
}