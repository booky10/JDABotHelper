package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (21:50 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Role;

public class RoleUpdatedPositionEvent extends RoleUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "position";

    private final Integer oldPositionRaw, newPositionRaw;

    public RoleUpdatedPositionEvent(JDA jda, Long response, Role role, Integer oldPositionRaw) {
        super(jda, response, role, oldPositionRaw, role.getPosition(), IDENTIFIER);

        this.oldPositionRaw = oldPositionRaw;
        this.newPositionRaw = role.getPositionRaw();
    }

    public Integer getOldPosition() {
        return getOldValue();
    }

    public Integer getNewPosition() {
        return getNewValue();
    }

    public Integer getOldPositionRaw() {
        return oldPositionRaw;
    }

    public Integer getNewPositionRaw() {
        return newPositionRaw;
    }
}