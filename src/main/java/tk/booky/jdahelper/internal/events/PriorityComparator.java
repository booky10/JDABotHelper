package tk.booky.jdahelper.internal.events;
// Created by booky10 in JDABotHelper (21:18 27.09.20)

import tk.booky.jdahelper.api.event.api.HandleEvent;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Comparator;

public final class PriorityComparator implements Comparator<Method> {

    @Override
    public int compare(Method e1, Method e2) {
        return getAnnotation(e1).priority().compareTo(getAnnotation(e2).priority());
    }

    protected HandleEvent getAnnotation(Method method) {
        for (Annotation annotation : method.getDeclaredAnnotations())
            if (annotation instanceof HandleEvent) return (HandleEvent) annotation;
        throw new IllegalStateException("Method \"" + method + "\" does not contain \"" + HandleEvent.class + "\"");
    }
}