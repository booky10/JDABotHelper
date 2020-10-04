package tk.booky.jdahelper.api.event.events.role;
// Created by booky10 in JDABotHelper (21:49 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;

import java.util.EnumSet;

public class RoleUpdatedPermissionsEvent extends RoleUpdatedEvent<EnumSet<Permission>> {

    public static final String IDENTIFIER = "permission";

    private final Long oldPermissionRaw, newPermissionsRaw;

    public RoleUpdatedPermissionsEvent(JDA jda, Long response, Role role, Long oldPermissionRaw) {
        super(jda, response, role, Permission.getPermissions(oldPermissionRaw), role.getPermissions(), IDENTIFIER);

        this.oldPermissionRaw = oldPermissionRaw;
        this.newPermissionsRaw = role.getPermissionsRaw();
    }

    public Long getOldPermissionRaw() {
        return oldPermissionRaw;
    }

    public Long getNewPermissionsRaw() {
        return newPermissionsRaw;
    }

    public EnumSet<Permission> getOldPermissions() {
        return getOldValue();
    }

    public EnumSet<Permission> getNewPermissions() {
        return getNewValue();
    }
}