package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (09:21 21.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import tk.booky.jdahelper.api.event.api.Event;

public class UserActivityEvent extends Event implements IUserActivityEvent {

    private final Guild guild;
    private final Member member;

    public UserActivityEvent(JDA jda, Long response, Guild guild, Member member) {
        super(jda, response);
        this.guild = guild;
        this.member = member;
    }

    @Override
    public Guild getGuild() {
        return guild;
    }

    @Override
    public Member getMember() {
        return member;
    }
}