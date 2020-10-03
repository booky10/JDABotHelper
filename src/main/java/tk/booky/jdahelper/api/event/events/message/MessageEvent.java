package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (21:52 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import tk.booky.jdahelper.api.event.api.Event;

public class MessageEvent extends Event {

    protected final Long messageId;
    protected final MessageChannel channel;

    public MessageEvent(JDA api, Long responseNumber, Long messageId, MessageChannel channel) {
        super(api, responseNumber);
        this.messageId = messageId;
        this.channel = channel;
    }

    public MessageChannel getChannel() {
        return channel;
    }

    public Long getMessageIDLong() {
        return messageId;
    }

    public String getMessageID() {
        return Long.toUnsignedString(messageId);
    }

    public boolean isFromType(ChannelType type) {
        return channel.getType() == type;
    }

    public boolean isFromGuild() {
        return getChannelType().isGuild();
    }

    public ChannelType getChannelType() {
        return channel.getType();
    }

    public Guild getGuild() {
        return getTextChannel().getGuild();
    }

    public TextChannel getTextChannel() {
        if (!isFromType(ChannelType.TEXT)) throw new IllegalStateException("This message event did not happen in a text channel");
        return (TextChannel) channel;
    }

    public PrivateChannel getPrivateChannel() {
        if (!isFromType(ChannelType.PRIVATE)) throw new IllegalStateException("This message event did not happen in a private channel");
        return (PrivateChannel) channel;
    }
}