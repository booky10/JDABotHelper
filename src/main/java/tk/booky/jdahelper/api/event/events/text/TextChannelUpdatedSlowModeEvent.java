package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:58 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class TextChannelUpdatedSlowModeEvent extends TextChannelUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "slowmode";

    public TextChannelUpdatedSlowModeEvent(JDA jda, Long response, TextChannel channel, Integer oldSlowMode) {
        super(jda, response, channel, oldSlowMode, channel.getSlowmode(), IDENTIFIER);
    }

    public Integer getOldSlowMode() {
        return getOldValue();
    }

    public Integer getNewSlowMode() {
        return getNewValue();
    }
}