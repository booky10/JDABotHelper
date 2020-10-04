package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:56 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class TextChannelUpdatedNameEvent extends TextChannelUpdatedEvent<String> {

    public static final String IDENTIFIER = "name";

    public TextChannelUpdatedNameEvent(JDA jda, Long response, TextChannel channel, String oldName) {
        super(jda, response, channel, oldName, channel.getName(), IDENTIFIER);
    }

    public String getOldName() {
        return getOldValue();
    }

    public String getNewName() {
        return getNewValue();
    }
}