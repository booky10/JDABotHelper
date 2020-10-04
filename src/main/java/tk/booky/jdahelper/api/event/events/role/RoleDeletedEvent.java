package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (21:43 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Role;

public class RoleDeletedEvent extends RoleEvent {

    public RoleDeletedEvent(JDA jda, Long response, Role deletedRole) {
        super(jda, response, deletedRole);
    }
}