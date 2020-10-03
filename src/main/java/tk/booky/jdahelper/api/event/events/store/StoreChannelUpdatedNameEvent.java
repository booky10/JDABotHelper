package tk.booky.jdahelper.api.event.events.store;
// Created by booky10 in JDABotHelper (21:55 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.StoreChannel;

public class StoreChannelUpdatedNameEvent extends StoreChannelUpdatedEvent<String> {

    public static final String IDENTIFIER = "name";

    public StoreChannelUpdatedNameEvent(JDA jda, Long response, StoreChannel channel, String prev) {
        super(jda, response, channel, prev, channel.getName(), IDENTIFIER);
    }

    public String getOldName() {
        return getOldValue();
    }

    public String getNewName() {
        return getNewValue();
    }

    @Override
    public String getOldValue() {
        return super.getOldValue();
    }

    @Override
    public String getNewValue() {
        return super.getNewValue();
    }
}