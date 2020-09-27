package tk.booky.jdahelper.api.event.events;
// Created by booky10 in JDABotHelper (20:06 27.09.20)

import net.dv8tion.jda.api.JDA;
import tk.booky.jdahelper.internal.manager.Helper;

public class Event {

    private final JDA jda;
    private final Long response;

    public Event(JDA jda, Long response) {
        this.jda = jda;
        this.response = response;
    }

    public final JDA getJDA() {
        return jda;
    }

    public Long getResponse() {
        return response;
    }

    /**
     * @return true if successful, if not false.
     */
    public final Boolean call() {
        Helper.getEventManager().callEvent(this);
        return !(this instanceof Cancellable) || !((Cancellable) this).isCancelled();
    }

    public String getEventName() {
        return getClass().getSimpleName();
    }
}