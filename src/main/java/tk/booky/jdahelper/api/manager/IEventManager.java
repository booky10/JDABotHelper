package tk.booky.jdahelper.api.manager;
// Created by booky10 in JDABotHelper (20:09 27.09.20)

import net.dv8tion.jda.api.events.Event;
import tk.booky.jdahelper.api.event.IListener;

public interface IEventManager {

    void callEvent(Event event);

    void registerListener(IListener listener);
}