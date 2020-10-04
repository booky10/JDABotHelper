package tk.booky.jdahelper.api.event.events.emote;
// Created by booky10 in JDABotHelper (21:52 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;

public class EmoteUpdatedRolesEvent extends EmoteUpdatedEvent<List<Role>> {

    public static final String IDENTIFIER = "roles";

    public EmoteUpdatedRolesEvent(JDA jda, Long response, Emote emote, List<Role> oldRoles) {
        super(jda, response, emote, oldRoles, emote.getRoles(), IDENTIFIER);
    }

    public List<Role> getOldRoles() {
        return getOldValue();
    }

    public List<Role> getNewRoles() {
        return getNewValue();
    }
}