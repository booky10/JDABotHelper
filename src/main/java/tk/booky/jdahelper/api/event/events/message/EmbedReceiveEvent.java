package tk.booky.jdahelper.api.event.events.message;
// Created by booky10 in JDABotHelper (21:54 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.util.Collections;
import java.util.List;

public class EmbedReceiveEvent extends MessageEvent {

    private final List<MessageEmbed> embeds;

    public EmbedReceiveEvent(JDA api, Long responseNumber, Long messageID, MessageChannel channel, List<MessageEmbed> embeds) {
        super(api, responseNumber, messageID, channel);

        this.embeds = Collections.unmodifiableList(embeds);
    }

    public List<MessageEmbed> getMessageEmbeds() {
        return embeds;
    }
}