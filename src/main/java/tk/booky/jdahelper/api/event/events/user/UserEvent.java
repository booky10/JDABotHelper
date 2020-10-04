package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (21:56 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import tk.booky.jdahelper.api.event.api.Event;

public class UserEvent extends Event {

    protected final User user;

    public UserEvent(JDA jda, Long response, User user) {
        super(jda, response);

        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getUserID() {
        return Long.toUnsignedString(getUserIDLong());
    }

    public Long getUserIDLong() {
        return getUser().getIdLong();
    }
}