package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (17:34 03.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageReaction;

public class DirectReactionAddEvent extends DirectReactionEvent {

    public DirectReactionAddEvent(JDA jda, Long response, Long userID, MessageReaction reaction) {
        super(jda, response, userID, reaction);
    }
}