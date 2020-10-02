package tk.booky.jdahelper.api.event.events.connection;
// Created by booky10 in JDABotHelper (21:42 27.09.20)

import net.dv8tion.jda.api.JDA;
import tk.booky.jdahelper.api.event.api.Event;

public class ConnectionReconnectedEvent extends Event {

    public ConnectionReconnectedEvent(JDA jda, Long response) {
        super(jda, response);
    }
}