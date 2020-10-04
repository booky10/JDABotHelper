package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (18:12 03.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageReaction;

public class ReactionRemoveEmoteEvent extends MessageEvent {

    private final MessageReaction removedReaction;

    public ReactionRemoveEmoteEvent(JDA api, Long responseNumber, Long messageID, MessageChannel channel, MessageReaction removedReaction) {
        super(api, responseNumber, messageID, channel);

        this.removedReaction = removedReaction;
    }

    public MessageReaction getRemovedReaction() {
        return removedReaction;
    }

    public MessageReaction.ReactionEmote getReactionEmote() {
        return getRemovedReaction().getReactionEmote();
    }
}