package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (21:50 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Role;

public class RoleUpdatedPositionEvent extends RoleUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "position";

    private final Integer oldPositionRaw, newPositionRaw;

    public RoleUpdatedPositionEvent(JDA jda, Long response, Role role, Integer previous, Integer oldPositionRaw, Integer newPositionRaw) {
        super(jda, response, role, previous, role.getPosition(), IDENTIFIER);
        this.oldPositionRaw = oldPositionRaw;
        this.newPositionRaw = newPositionRaw;
    }

    public Integer getOldPosition() {
        return getOldValue();
    }

    public Integer getNewPosition() {
        return getNewValue();
    }

    public Integer getOldPositionRaw(){
        return oldPositionRaw;
    }

    public Integer getNewPositionRaw() {
        return newPositionRaw;
    }

    @Override
    public Integer getOldValue() {
        return super.getOldValue();
    }

    @Override
    public Integer getNewValue() {
        return super.getNewValue();
    }
}