package tk.booky.jdahelper.internal.events;
// Created by booky10 in JDABotHelper (18:40 27.09.20)

import tk.booky.jdahelper.api.event.api.AbstractEventManager;
import tk.booky.jdahelper.api.event.api.Event;
import tk.booky.jdahelper.api.event.api.HandleEvent;
import tk.booky.jdahelper.api.event.api.IListener;
import tk.booky.jdahelper.utils.Pair;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public final class EventManager extends AbstractEventManager {

    private final HashMap<Method, Class<? extends Event>> registeredHandlers = new HashMap<>();
    private final HashMap<Method, IListener> listenerInstances = new HashMap<>();

    @Override
    public final void callEvent(Event event) {
        List<Method> dataList = new ArrayList<>();

        for (Method method : registeredHandlers.keySet())
            if (registeredHandlers.get(method).isAssignableFrom(event.getClass()))
                dataList.add(method);

        sortDataList(dataList);

        for (Method method : dataList) {
            try {
                method.setAccessible(true);
                method.invoke(listenerInstances.get(method), event);
            } catch (IllegalAccessException | InvocationTargetException exception) {
                exception.printStackTrace();
            }
        }
    }

    private void sortDataList(List<Method> data) {
        Comparator<Method> comparator = new PriorityComparator();
        data.sort(comparator);
    }

    @Override
    public final void registerListener(IListener listener) {
        for (Method method : listener.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            boolean has = false;

            for (Annotation annotation : method.getDeclaredAnnotations())
                if (annotation.annotationType().equals(HandleEvent.class)) has = true;
            if (!has) continue;

            try {
                registeredHandlers.put(method, (Class<? extends Event>) method.getParameterTypes()[0]);
                listenerInstances.put(method, listener);
            } catch (Throwable ignored) {
            }
        }
    }

    public final void unregisterListener(IListener listener) {
        unregisterListener(listener.getClass());
    }

    public final void unregisterListener(Class<? extends IListener> clazz) {
        List<Method> methods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            method.setAccessible(true);
            methods.add(method);
        }

        for (Method method : new ArrayList<>(registeredHandlers.keySet())) {
            if (methods.contains(method)) registeredHandlers.remove(method);
        }
    }
}