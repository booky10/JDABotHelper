package tk.booky.jdahelper.api.event.events.connection;
// Created by booky10 in JDABotHelper (21:23 04.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.handle.GuildSetupController;
import tk.booky.jdahelper.api.event.api.Event;

public class ConnectionStartedEvent extends Event {

    private final Integer unavailableGuilds, availableGuilds;

    public ConnectionStartedEvent(JDA jda, Long response) {
        super(jda, response);

        unavailableGuilds = ((JDAImpl) jda).getGuildSetupController().getSetupNodes(GuildSetupController.Status.UNAVAILABLE).size();
        availableGuilds = Math.toIntExact(jda.getGuildCache().size());
    }

    public Integer getAvailableGuildCount() {
        return availableGuilds;
    }

    public Integer getUnavailableGuildCount() {
        return unavailableGuilds;
    }

    public Integer getGuildTotalCount() {
        return getAvailableGuildCount() + getUnavailableGuildCount();
    }
}