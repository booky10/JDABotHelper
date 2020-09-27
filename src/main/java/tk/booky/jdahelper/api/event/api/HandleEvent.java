package tk.booky.jdahelper.api.event.api;
// Created by booky10 in JDABotHelper (20:03 27.09.20)

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HandleEvent {

    EventPriority priority() default EventPriority.NORMAL;
}