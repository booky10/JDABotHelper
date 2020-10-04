package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (21:53 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

public class MessageUpdatedEvent extends MessageEvent {

    private final Message message;

    public MessageUpdatedEvent(JDA api, Long responseNumber, Message message) {
        super(api, responseNumber, message.getIdLong(), message.getChannel());

        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public User getAuthor() {
        return getMessage().getAuthor();
    }

    public Member getMember() {
        return getMessage().getMember();
    }
}