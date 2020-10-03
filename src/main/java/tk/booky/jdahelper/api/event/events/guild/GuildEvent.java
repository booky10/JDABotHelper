package tk.booky.jdahelper.api.event.events.guild;
// Created by booky10 in JDABotHelper (21:17 03.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import tk.booky.jdahelper.api.event.api.Event;

public class GuildEvent extends Event {

    protected final Guild guild;

    public GuildEvent(JDA jda, Long response, Guild guild) {
        super(jda, response);
        this.guild = guild;
    }

    public Guild getGuild() {
        return guild;
    }
}