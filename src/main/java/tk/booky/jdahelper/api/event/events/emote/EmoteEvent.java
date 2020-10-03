package tk.booky.jdahelper.api.event.events.emote;
// Created by booky10 in JDABotHelper (22:00 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Guild;
import tk.booky.jdahelper.api.event.api.Event;

public class EmoteEvent extends Event {

    protected final Emote emote;

    public EmoteEvent(JDA jda, Long response, Emote emote) {
        super(jda, response);
        this.emote = emote;
    }

    public Guild getGuild() {
        return emote.getGuild();
    }

    public Emote getEmote() {
        return emote;
    }

    public Boolean isManaged() {
        return emote.isManaged();
    }
}