package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (21:48 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Role;

public class RoleUpdatedNameEvent extends RoleUpdatedEvent<String> {

    public static final String IDENTIFIER = "name";

    public RoleUpdatedNameEvent(JDA jda, Long response, Role role, String previous, String next) {
        super(jda, response, role, previous, next, IDENTIFIER);
    }

    public String getOldName() {
        return getOldValue();
    }

    public String getNewName() {
        return getNewValue();
    }

    @Override
    public String getOldValue() {
        return super.getOldValue();
    }

    @Override
    public String getNewValue() {
        return super.getNewValue();
    }
}