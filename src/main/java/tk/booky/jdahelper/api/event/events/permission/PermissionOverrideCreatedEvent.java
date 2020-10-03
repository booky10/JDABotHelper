package tk.booky.jdahelper.api.event.events.permission;
// Created by booky10 in JDABotHelper (21:55 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.PermissionOverride;

public class PermissionOverrideCreatedEvent extends PermissionOverrideEvent{

    public PermissionOverrideCreatedEvent(JDA jda, Long response, GuildChannel channel, PermissionOverride override) {
        super(jda, response, channel, override);
    }
}