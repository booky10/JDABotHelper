package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (21:52 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;

public class DirectReactionEvent extends DirectMessageEvent {

    protected final Long userID;
    protected final MessageReaction reaction;

    public DirectReactionEvent(JDA jda, Long response, Long userID, MessageReaction reaction) {
        super(jda, response, reaction.getMessageIdLong(), reaction.getPrivateChannel());
        this.userID = userID;
        this.reaction = reaction;
    }

    public MessageReaction getReaction() {
        return reaction;
    }

    @Override
    public User getUser() {
        return userID == getJDA().getSelfUser().getIdLong() ? getJDA().getSelfUser() : getChannel().getUser();
    }
}