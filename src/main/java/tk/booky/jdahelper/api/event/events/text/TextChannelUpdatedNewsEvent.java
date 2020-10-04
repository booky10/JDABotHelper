package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:58 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class TextChannelUpdatedNewsEvent extends TextChannelUpdatedEvent<Boolean> {

    public static final String IDENTIFIER = "news";

    public TextChannelUpdatedNewsEvent(JDA jda, Long response, TextChannel channel, Boolean oldNews) {
        super(jda, response, channel, oldNews, !oldNews, IDENTIFIER);
    }

    public Boolean getOldNews() {
        return getOldValue();
    }

    public Boolean getNewNews() {
        return getNewValue();
    }
}