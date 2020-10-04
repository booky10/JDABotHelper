package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (21:48 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Role;

public class RoleUpdatedMentionable extends RoleUpdatedEvent<Boolean> {


    public static final String IDENTIFIER = "mentionable";

    public RoleUpdatedMentionable(JDA api, Long responseNumber, Role role, Boolean wasMentionable) {
        super(api, responseNumber, role, wasMentionable, !wasMentionable, IDENTIFIER);
    }

    public Boolean wasMentionable() {
        return getOldValue();
    }

    public Boolean isMentionable(){
        return getNewValue();
    }
}