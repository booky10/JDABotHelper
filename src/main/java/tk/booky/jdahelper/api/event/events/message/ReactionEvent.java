package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (21:54 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.internal.requests.CompletedRestAction;

public class ReactionEvent extends MessageEvent {

    protected final Long userID;
    protected User issuer;
    protected Member member;
    protected MessageReaction reaction;


    public ReactionEvent(JDA api, Long responseNumber, User user,
                         Member member, MessageReaction reaction, Long userID) {
        super(api, responseNumber, reaction.getMessageIdLong(), reaction.getChannel());
        this.userID = userID;
        this.issuer = user;
        this.member = member;
        this.reaction = reaction;
    }

    public Long getUserIDLong() {
        return userID;
    }

    public String getUserID() {
        return Long.toUnsignedString(userID);
    }

    public User getUser() {
        return issuer == null && isFromType(ChannelType.PRIVATE) ? getPrivateChannel().getUser() : issuer;
    }

    public Member getMember() {
        return member;
    }

    public MessageReaction getReaction() {
        return reaction;
    }

    public MessageReaction.ReactionEmote getReactionEmote() {
        return reaction.getReactionEmote();
    }

    public RestAction<Member> retrieveMember() {
        if (member != null) return new CompletedRestAction<>(getJDA(), member);
        return getGuild().retrieveMemberById(getUserIDLong());
    }

    public RestAction<Message> retrieveMessage() {
        return getChannel().retrieveMessageById(getMessageID());
    }
}