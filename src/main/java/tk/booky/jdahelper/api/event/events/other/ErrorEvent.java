package tk.booky.jdahelper.api.event.events.other;
// Created by booky10 in JDABotHelper (21:44 27.09.20)

import net.dv8tion.jda.api.JDA;
import tk.booky.jdahelper.api.event.api.Event;

public class ErrorEvent extends Event {

    protected final Throwable throwable;
    protected final Boolean logged;

    public ErrorEvent(JDA jda, Throwable throwable, Boolean logged) {
        super(jda);
        this.throwable = throwable;
        this.logged = logged;
    }

    public Boolean isLogged() {
        return logged;
    }

    public Throwable getCause() {
        return throwable;
    }
}