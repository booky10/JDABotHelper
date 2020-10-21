package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (18:12 03.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageReaction;

public class ReactionAddEvent extends ReactionEvent {

    public ReactionAddEvent(JDA api, Long responseNumber, Member member, MessageReaction addedReaction) {
        super(api, responseNumber, member.getUser(), member, addedReaction, member.getIdLong());
    }
}