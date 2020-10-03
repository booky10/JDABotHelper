package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (20:14 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import tk.booky.jdahelper.api.event.api.Event;

public class DirectChannelDeletedEvent extends Event {

    protected final PrivateChannel channel;

    public DirectChannelDeletedEvent(JDA jda, Long response, PrivateChannel channel) {
        super(jda, response);
        this.channel = channel;
    }

    public PrivateChannel getChannel() {
        return channel;
    }

    public User getUser() {
        return channel.getUser();
    }
}