package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (21:45 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import tk.booky.jdahelper.api.status.Status;

public class UserActivityStatusChangedEvent extends UserUpdatedEvent<Status> implements IUserActivityEvent {

    public static final String IDENTIFIER = "status";

    protected final Member member;

    public UserActivityStatusChangedEvent(JDA jda, Long response, Member member, Status oldStatus) {
        super(jda, response, member.getUser(), oldStatus, Status.fromJDA(member.getOnlineStatus()), IDENTIFIER);

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

    public Status getOldStatus() {
        return getOldValue();
    }

    public Status getNewStatus() {
        return getNewValue();
    }
}