package tk.booky.jdahelper.api.event.events.self;
// Created by booky10 in JDABotHelper (21:46 27.09.20)

import net.dv8tion.jda.api.JDA;

public class SelfUpdatedAvatarEvent extends SelfUpdatedEvent<String> {

    public static final String IDENTIFIER = "avatar", AVATAR_URL = "https://cdn.discordapp.com/avatars/%s/%s%s";

    public SelfUpdatedAvatarEvent(JDA api, Long responseNumber, String oldAvatarId) {
        super(api, responseNumber, oldAvatarId, api.getSelfUser().getAvatarId(), IDENTIFIER);
    }

    public String getOldAvatarID() {
        return getOldValue();
    }

    public String getOldAvatarURL() {
        return getOldAvatarID() == null ? null : String.format(AVATAR_URL, getSelfUser().getId(), getOldAvatarID(), getOldAvatarID().startsWith("a_") ? ".gif" : ".png");
    }

    public String getNewAvatarID() {
        return getNewValue();
    }

    public String getNewAvatarURL() {
        return getNewAvatarID() == null ? null : String.format(AVATAR_URL, getSelfUser().getId(), getNewAvatarID(), getNewAvatarID().startsWith("a_") ? ".gif" : ".png");
    }
}