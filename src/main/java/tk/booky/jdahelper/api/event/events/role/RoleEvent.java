package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (21:59 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import tk.booky.jdahelper.api.event.api.Event;

public class RoleEvent extends Event {

    protected final Role role;

    public RoleEvent(JDA jda, Long response, Role role) {
        super(jda, response);

        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public Guild getGuild() {
        return getRole().getGuild();
    }

    public String getRoleID() {
        return Long.toUnsignedString(getRoleIDLong());
    }

    public Long getRoleIDLong() {
        return getRole().getIdLong();
    }

    public String getGuildID() {
        return Long.toUnsignedString(getGuildIDLong());
    }

    public Long getGuildIDLong() {
        return getGuild().getIdLong();
    }
}