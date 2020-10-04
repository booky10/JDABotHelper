package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (21:45 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;

import java.util.EnumSet;

public class UserUpdatedFlagsEvent extends UserUpdatedEvent<EnumSet<User.UserFlag>> {

    public static final String IDENTIFIER = "public_flags";

    public UserUpdatedFlagsEvent(JDA jda, Long response, User user, EnumSet<User.UserFlag> oldFlags) {
        super(jda, response, user, oldFlags, user.getFlags(), IDENTIFIER);
    }

    public EnumSet<User.UserFlag> getOldFlags() {
        return getOldValue();
    }

    public EnumSet<User.UserFlag> getNewFlags() {
        return getNewValue();
    }

    public Integer getOldFlagsRaw() {
        return User.UserFlag.getRaw(getOldFlags());
    }

    public Integer getNewFlagsRaw() {
        return User.UserFlag.getRaw(getNewFlags());
    }
}