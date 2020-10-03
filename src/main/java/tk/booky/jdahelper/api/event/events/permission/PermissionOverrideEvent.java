package tk.booky.jdahelper.api.event.events.permission;
// Created by booky10 in JDABotHelper (22:00 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import tk.booky.jdahelper.api.event.events.guild.GuildEvent;

public class PermissionOverrideEvent extends GuildEvent {

    protected final GuildChannel channel;
    protected final PermissionOverride override;

    public PermissionOverrideEvent(JDA jda, Long response, GuildChannel channel, PermissionOverride override) {
        super(jda, response, channel.getGuild());
        this.channel = channel;
        this.override = override;
    }

    public ChannelType getChannelType() {
        return channel.getType();
    }

    public GuildChannel getChannel() {
        return channel;
    }

    public PermissionOverride getOverride() {
        return override;
    }

    public TextChannel getTextChannel() {
        if (channel instanceof TextChannel) return (TextChannel) channel;
        throw new IllegalStateException("This override is for a channel of type " + getChannelType());
    }

    public VoiceChannel getVoiceChannel() {
        if (channel instanceof VoiceChannel) return (VoiceChannel) channel;
        throw new IllegalStateException("This override is for a channel of type " + getChannelType());
    }

    public StoreChannel getStoreChannel() {
        if (channel instanceof StoreChannel) return (StoreChannel) channel;
        throw new IllegalStateException("This override is for a channel of type " + getChannelType());
    }

    public Category getCategory() {
        if (channel instanceof Category) return (Category) channel;
        throw new IllegalStateException("This override is for a channel of type " + getChannelType());
    }

    public boolean isRoleOverride() {
        return override.isRoleOverride();
    }

    public boolean isMemberOverride() {
        return override.isMemberOverride();
    }

    public IPermissionHolder getPermissionHolder() {
        return isMemberOverride() ? override.getMember() : isRoleOverride() ? override.getRole() : null;
    }

    public Member getMember() {
        return override.getMember();
    }

    public Role getRole() {
        return override.getRole();
    }
}