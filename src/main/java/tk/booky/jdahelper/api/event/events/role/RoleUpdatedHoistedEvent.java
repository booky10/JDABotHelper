package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (21:48 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Role;

public class RoleUpdatedHoistedEvent extends RoleUpdatedEvent<Boolean> {

    public static final String IDENTIFIER = "hoist";

    public RoleUpdatedHoistedEvent(JDA jda, Long response, Role role, Boolean wasHoisted) {
        super(jda, response, role, wasHoisted, !wasHoisted, IDENTIFIER);
    }

    public Boolean wasHoisted() {
        return getOldValue();
    }

    public Boolean isHoisted() {
        return getNewValue();
    }
}