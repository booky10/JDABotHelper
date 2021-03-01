package tk.booky.jdahelper.internal.events;
// Created by booky10 in JDABotHelper (21:18 27.09.20)

import tk.booky.jdahelper.api.event.HandleEvent;
import tk.booky.jdahelper.api.exceptions.events.NoAnnotationException;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public final class PriorityComparator implements Comparator<Method> {

    @Override
    public int compare(Method method1, Method method2) {
        return getAnnotation(method1).priority().compareTo(getAnnotation(method2).priority());
    }

    protected HandleEvent getAnnotation(Method method) {
        return Arrays.stream(method.getDeclaredAnnotations())
                .filter(annotation -> annotation instanceof HandleEvent)
                .map(annotation -> (HandleEvent) annotation)
                .findAny().orElseGet(() -> {
                    throw new NoAnnotationException(method.toString());
                });
    }
}