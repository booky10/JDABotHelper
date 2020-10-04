package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (21:45 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;

public class UserUpdatedAvatarEvent extends UserUpdatedEvent<String> {

    public static final String IDENTIFIER = "avatar";

    public UserUpdatedAvatarEvent(JDA jda, Long response, User user, String oldAvatar) {
        super(jda, response, user, oldAvatar, user.getAvatarId(), IDENTIFIER);
    }

    public String getOldAvatarID() {
        return getOldValue();
    }

    public String getOldAvatarURL() {
        return getOldAvatarID() == null ? null : String.format(User.AVATAR_URL, getUser().getId(), getOldAvatarID(), getOldAvatarID().startsWith("a_") ? "gif" : "png");
    }

    public String getNewAvatarID() {
        return getNewValue();
    }

    public String getNewAvatarURL() {
        return getNewAvatarID() == null ? null : String.format(User.AVATAR_URL, getUser().getId(), getNewAvatarID(), getNewAvatarID().startsWith("a_") ? "gif" : "png");
    }
}