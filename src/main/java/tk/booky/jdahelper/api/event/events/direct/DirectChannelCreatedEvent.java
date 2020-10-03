package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (20:14 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import tk.booky.jdahelper.api.event.api.Event;

public class DirectChannelCreatedEvent extends Event {

    private final PrivateChannel channel;

    public DirectChannelCreatedEvent(JDA jda, PrivateChannel channel) {
        super(jda);
        this.channel = channel;
    }

    public PrivateChannel getChannel() {
        return channel;
    }

    public User getUser() {
        return channel.getUser();
    }
}