package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (21:45 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;

import java.time.OffsetDateTime;

public class UserCaughtTypingEvent extends UserEvent {

    private final MessageChannel channel;
    protected final OffsetDateTime timestamp;

    public UserCaughtTypingEvent(JDA jda, Long response, User user, MessageChannel channel, OffsetDateTime timestamp) {
        super(jda, response, user);
        this.channel = channel;
        this.timestamp = timestamp;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public MessageChannel getChannel() {
        return channel;
    }

    public Boolean isFromType(ChannelType type) {
        return channel.getType() == type;
    }

    public ChannelType getType() {
        return channel.getType();
    }

    public PrivateChannel getPrivateChannel() {
        return isFromType(ChannelType.PRIVATE) ? (PrivateChannel) channel : null;
    }

    public TextChannel getTextChannel() {
        return isFromType(ChannelType.TEXT) ? (TextChannel) channel : null;
    }

    public Guild getGuild() {
        return isFromType(ChannelType.TEXT) ? getTextChannel().getGuild() : null;
    }

    public Member getMember() {
        return isFromType(ChannelType.TEXT) ? getGuild().getMember(getUser()) : null;
    }
}