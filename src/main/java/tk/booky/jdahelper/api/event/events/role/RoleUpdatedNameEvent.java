package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (21:48 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Role;

public class RoleUpdatedNameEvent extends RoleUpdatedEvent<String> {

    public static final String IDENTIFIER = "name";

    public RoleUpdatedNameEvent(JDA jda, Long response, Role role, String oldName) {
        super(jda, response, role, oldName, role.getName(), IDENTIFIER);
    }

    public String getOldName() {
        return getOldValue();
    }

    public String getNewName() {
        return getNewValue();
    }
}