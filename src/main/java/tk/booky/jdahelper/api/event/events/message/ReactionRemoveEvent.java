package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (18:12 03.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;

public class ReactionRemoveEvent extends ReactionEvent {

    public ReactionRemoveEvent(JDA api, Long responseNumber, User user, Member member, MessageReaction removedReaction, Long userID) {
        super(api, responseNumber, user, member, removedReaction, userID);
    }
}