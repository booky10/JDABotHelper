package tk.booky.jdahelper.api.event.events.store;
// Created by booky10 in JDABotHelper (21:57 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StoreChannel;
import tk.booky.jdahelper.api.event.api.Event;

public class StoreChannelEvent extends Event {

    protected final StoreChannel channel;

    public StoreChannelEvent(JDA jda, Long response, StoreChannel channel) {
        super(jda, response);

        this.channel = channel;
    }

    public StoreChannel getChannel() {
        return channel;
    }

    public String getID(){
        return Long.toUnsignedString(getIDLong());
    }

    public Long getIDLong(){
        return getChannel().getIdLong();
    }
}