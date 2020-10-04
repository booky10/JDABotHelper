package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (18:12 03.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;

public class ReactionAddEvent extends ReactionEvent {

    public ReactionAddEvent(JDA api, Long responseNumber, User user, Member member, MessageReaction addedReaction, Long userID) {
        super(api, responseNumber, user, member, addedReaction, userID);
    }
}