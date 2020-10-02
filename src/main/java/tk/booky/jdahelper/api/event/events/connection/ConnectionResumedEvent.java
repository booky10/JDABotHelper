package tk.booky.jdahelper.api.event.events.connection;
// Created by booky10 in JDABotHelper (21:42 27.09.20)

import net.dv8tion.jda.api.JDA;
import tk.booky.jdahelper.api.event.api.Event;

public class ConnectionResumedEvent extends Event {

    public ConnectionResumedEvent(JDA jda, Long response) {
        super(jda, response);
    }
}