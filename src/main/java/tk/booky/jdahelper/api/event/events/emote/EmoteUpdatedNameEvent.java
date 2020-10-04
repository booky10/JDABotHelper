package tk.booky.jdahelper.api.event.events.emote;
// Created by booky10 in JDABotHelper (21:51 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Emote;

public class EmoteUpdatedNameEvent extends EmoteUpdatedEvent<String> {

    public static final String IDENTIFIER = "name";

    public EmoteUpdatedNameEvent(JDA jda, Long response, Emote emote, String oldName) {
        super(jda, response, emote, oldName, emote.getName(), IDENTIFIER);
    }

    public String getOldName() {
        return getOldValue();
    }

    public String getNewName() {
        return getNewValue();
    }
}