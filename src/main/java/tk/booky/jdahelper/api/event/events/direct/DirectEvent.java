package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (14:15 04.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import tk.booky.jdahelper.api.event.api.Event;

public class DirectEvent extends Event {

    protected final PrivateChannel channel;

    public DirectEvent(JDA jda, Long response, PrivateChannel channel) {
        super(jda, response);

        this.channel = channel;
    }

    public DirectEvent(JDA jda, PrivateChannel channel) {
        super(jda);

        this.channel = channel;
    }

    public PrivateChannel getChannel() {
        return channel;
    }

    public User getUser() {
        return getChannel().getUser();
    }

    public String getID() {
        return Long.toUnsignedString(getIDLong());
    }

    public Long getIDLong() {
        return getChannel().getIdLong();
    }

    public String getUserID() {
        return Long.toUnsignedString(getUserIDLong());
    }

    public Long getUserIDLong() {
        return getUser().getIdLong();
    }
}