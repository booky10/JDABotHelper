package tk.booky.jdahelper.api.event.events.permission;
// Created by booky10 in JDABotHelper (21:55 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.PermissionOverride;

import java.util.EnumSet;

public class PermissionOverrideUpdatedEvent extends PermissionOverrideEvent {

    private final Long oldAllow, oldDeny;

    public PermissionOverrideUpdatedEvent(JDA jda, Long response, GuildChannel channel, PermissionOverride override, Long oldAllow, Long oldDeny) {
        super(jda, response, channel, override);
        this.oldAllow = oldAllow;
        this.oldDeny = oldDeny;
    }

    public Long getOldAllowRaw() {
        return oldAllow;
    }

    public Long getOldDenyRaw() {
        return oldDeny;
    }

    public Long getOldInheritedRaw() {
        return ~(oldAllow | oldDeny);
    }

    public EnumSet<Permission> getOldAllow() {
        return Permission.getPermissions(oldAllow);
    }

    public EnumSet<Permission> getOldDeny() {
        return Permission.getPermissions(oldDeny);
    }

    public EnumSet<Permission> getOldInherited() {
        return Permission.getPermissions(getOldInheritedRaw());
    }
}