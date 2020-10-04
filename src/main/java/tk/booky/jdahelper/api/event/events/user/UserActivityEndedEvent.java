package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (21:46 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import tk.booky.jdahelper.api.activities.Activity;

public class UserActivityEndedEvent extends UserEvent implements IUserActivityEvent {

    protected final Activity oldActivity;
    protected final Member member;

    public UserActivityEndedEvent(JDA jda, Long response, Member member, Activity oldActivity) {
        super(jda, response, member.getUser());
        this.oldActivity = oldActivity;
        this.member = member;
    }

    public Activity getOldActivity() {
        return oldActivity;
    }

    @Override
    public Guild getGuild() {
        return member.getGuild();
    }

    @Override
    public Member getMember() {
        return member;
    }
}