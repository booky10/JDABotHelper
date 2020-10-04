package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (13:28 04.10.20)

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

public interface IUserActivityEvent {

    Guild getGuild();

    Member getMember();
}