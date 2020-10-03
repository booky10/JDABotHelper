package tk.booky.jdahelper.api.event.events.emote;
// Created by booky10 in JDABotHelper (21:51 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Emote;

public class EmoteRemoveEvent extends EmoteEvent {

    public EmoteRemoveEvent(JDA jda, Long response, Emote emote) {
        super(jda, response, emote);
    }
}