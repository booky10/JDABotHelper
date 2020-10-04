package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (21:44 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;

public class UserUpdatedNameEvent extends UserUpdatedEvent<String> {

    public static final String IDENTIFIER = "name";

    public UserUpdatedNameEvent(JDA jda, Long response, User user, String oldName) {
        super(jda, response, user, oldName, user.getName(), IDENTIFIER);
    }

    public String getOldName() {
        return getOldValue();
    }

    public String getNewName() {
        return getNewValue();
    }
}