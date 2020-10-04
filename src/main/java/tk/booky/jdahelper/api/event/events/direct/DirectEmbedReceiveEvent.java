package tk.booky.jdahelper.api.event.events.direct;
// Created by booky10 in JDABotHelper (21:52 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.PrivateChannel;

import java.util.List;

public class DirectEmbedReceiveEvent extends DirectMessageEvent {

    private final List<MessageEmbed> embeds;

    public DirectEmbedReceiveEvent(JDA jda, Long response, Long messageID, PrivateChannel channel, List<MessageEmbed> embeds) {
        super(jda, response, messageID, channel);

        this.embeds = embeds;
    }

    public List<MessageEmbed> getEmbeds() {
        return embeds;
    }
}