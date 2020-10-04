package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (21:48 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Role;

import java.awt.*;

public class RoleUpdatedColorEvent extends RoleUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "color";

    public RoleUpdatedColorEvent(JDA api, Long responseNumber, Role role, Integer oldColor) {
        super(api, responseNumber, role, oldColor, role.getColorRaw(), IDENTIFIER);
    }

    public Color getOldColor() {
        return getOldColorRaw() != Role.DEFAULT_COLOR_RAW ? new Color(getOldColorRaw()) : null;
    }

    public Integer getOldColorRaw() {
        return getOldValue();
    }

    public Color getNewColor() {
        return getNewColorRaw() != Role.DEFAULT_COLOR_RAW ? new Color(getNewColorRaw()) : null;
    }

    public Integer getNewColorRaw() {
        return getNewValue();
    }
}