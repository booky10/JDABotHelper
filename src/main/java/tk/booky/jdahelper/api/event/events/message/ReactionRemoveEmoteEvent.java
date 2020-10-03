package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (18:12 03.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageReaction;

public class ReactionRemoveEmoteEvent extends MessageEvent {

    private final MessageReaction reaction;

    public ReactionRemoveEmoteEvent(JDA api, Long responseNumber, Long messageId, MessageChannel channel, MessageReaction reaction) {
        super(api, responseNumber, messageId, channel);
        this.reaction = reaction;
    }

    public MessageReaction getReaction() {
        return reaction;
    }

    public MessageReaction.ReactionEmote getReactionEmote() {
        return reaction.getReactionEmote();
    }
}