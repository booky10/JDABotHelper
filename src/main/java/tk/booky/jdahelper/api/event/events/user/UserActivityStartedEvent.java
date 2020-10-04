package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (21:46 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import tk.booky.jdahelper.api.activities.Activity;

public class UserActivityStartedEvent extends UserEvent implements IUserActivityEvent {

    protected final Activity newActivity;
    protected final Member member;

    public UserActivityStartedEvent(JDA jda, Long response, Member member, Activity newActivity) {
        super(jda, response, member.getUser());

        this.newActivity = newActivity;
        this.member = member;
    }

    public Activity getNewActivity() {
        return newActivity;
    }

    @Override
    public Guild getGuild() {
        return getMember().getGuild();
    }

    @Override
    public Member getMember() {
        return member;
    }
}