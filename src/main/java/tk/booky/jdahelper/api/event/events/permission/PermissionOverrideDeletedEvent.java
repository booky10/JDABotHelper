package tk.booky.jdahelper.api.event.events.permission;
// Created by booky10 in JDABotHelper (21:55 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.PermissionOverride;

public class PermissionOverrideDeletedEvent extends PermissionOverrideEvent {

    public PermissionOverrideDeletedEvent(JDA jda, Long response, GuildChannel channel, PermissionOverride deletedOverride) {
        super(jda, response, channel, deletedOverride);
    }
}