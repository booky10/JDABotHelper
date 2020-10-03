package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (21:52 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;

public class DirectMessageUpdatedEvent extends DirectMessageEvent{

    private final Message message;

    public DirectMessageUpdatedEvent(JDA jda, Long response, Long messageID, PrivateChannel channel, Message message) {
        super(jda, response, messageID, channel);
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public User getAuthor(){
        return message.getAuthor();
    }
}