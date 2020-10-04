package tk.booky.jdahelper.api.event.events.text;
// Created by booky10 in JDABotHelper (21:57 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

public class TextChannelUpdatedPositionEvent extends TextChannelUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "position";

    public TextChannelUpdatedPositionEvent(JDA jda, Long response, TextChannel channel, Integer oldPosition) {
        super(jda, response, channel, oldPosition, channel.getPositionRaw(), IDENTIFIER);
    }

    public Integer getOldPosition() {
        return getOldValue();
    }

    public Integer getNewPosition() {
        return getNewValue();
    }
}