package tk.booky.jdahelper.internal.manager;
// Created by booky10 in JDABotHelper (18:50 27.09.20)

import tk.booky.jdahelper.api.activities.IActivityProvider;
import tk.booky.jdahelper.api.event.api.AbstractEventManager;
import tk.booky.jdahelper.api.status.IStatusProvider;
import tk.booky.jdahelper.internal.events.EventManager;
import tk.booky.jdahelper.internal.events.Listener;
import tk.booky.jdahelper.internal.implementations.ActivityProvider;
import tk.booky.jdahelper.internal.implementations.StatusProvider;

public class Helper {

    private static IActivityProvider activityProvider;
    private static IStatusProvider statusProvider;
    private static AbstractEventManager eventManager;
    private static Listener listener;

    public static IActivityProvider getActivityProvider() {
        if (activityProvider == null) activityProvider = new ActivityProvider();
        return activityProvider;
    }

    public static IStatusProvider getStatusProvider() {
        if (statusProvider == null) statusProvider = new StatusProvider();
        return statusProvider;
    }

    public static Listener getListener() {
        if (listener == null) listener = new Listener();
        return listener;
    }

    public static AbstractEventManager getEventManager() {
        if (eventManager == null) eventManager = new EventManager();
        return eventManager;
    }
}