package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (21:45 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import tk.booky.jdahelper.api.activities.Activity;

import java.util.List;

public class UserActivityUpdatedOrderEvent extends UserUpdatedEvent<List<Activity>> implements IUserActivityEvent {

    public static final String IDENTIFIER = "activity_order";

    protected final Member member;

    public UserActivityUpdatedOrderEvent(JDA jda, Long response, List<Activity> oldActivities, Member member) {
        super(jda, response, member.getUser(), oldActivities, Activity.fromJDA(member.getActivities()), IDENTIFIER);

        this.member = member;
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