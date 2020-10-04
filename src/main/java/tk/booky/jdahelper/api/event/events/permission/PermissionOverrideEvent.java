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
        return getChannel().getType();
    }

    public GuildChannel getChannel() {
        return channel;
    }

    public PermissionOverride getOverride() {
        return override;
    }

    public TextChannel getTextChannel() {
        if (getChannel() instanceof TextChannel) return (TextChannel) getChannel();
        throw new IllegalStateException("This override is for a channel of type " + getChannelType());
    }

    public VoiceChannel getVoiceChannel() {
        if (getChannel() instanceof VoiceChannel) return (VoiceChannel) getChannel();
        throw new IllegalStateException("This override is for a channel of type " + getChannelType());
    }

    public StoreChannel getStoreChannel() {
        if (getChannel() instanceof StoreChannel) return (StoreChannel) getChannel();
        throw new IllegalStateException("This override is for a channel of type " + getChannelType());
    }

    public Category getCategory() {
        if (getChannel() instanceof Category) return (Category) getChannel();
        throw new IllegalStateException("This override is for a channel of type " + getChannelType());
    }

    public boolean isRoleOverride() {
        return getOverride().isRoleOverride();
    }

    public boolean isMemberOverride() {
        return getOverride().isMemberOverride();
    }

    public IPermissionHolder getPermissionHolder() {
        return isMemberOverride() ? getOverride().getMember() : isRoleOverride() ? getOverride().getRole() : null;
    }

    public Member getMember() {
        return getOverride().getMember();
    }

    public Role getRole() {
        return getOverride().getRole();
    }
}