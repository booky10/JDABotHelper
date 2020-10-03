package tk.booky.jdahelper.api.event.events.self;
// Created by booky10 in JDABotHelper (21:46 27.09.20)

import net.dv8tion.jda.api.JDA;

public class SelfUpdatedAvatarEvent extends SelfUpdatedEvent<String> {

    public static final String IDENTIFIER = "avatar";
    private static final String AVATAR_URL = "https://cdn.discordapp.com/avatars/%s/%s%s";

    public SelfUpdatedAvatarEvent(JDA api, Long responseNumber, String oldAvatarId) {
        super(api, responseNumber, oldAvatarId, api.getSelfUser().getAvatarId(), IDENTIFIER);
    }

    public String getOldAvatarId() {
        return getOldValue();
    }

    public String getOldAvatarUrl() {
        return previous == null ? null : String.format(AVATAR_URL, getSelfUser().getId(), previous, previous.startsWith("a_") ? ".gif" : ".png");
    }

    public String getNewAvatarId() {
        return getNewValue();
    }

    public String getNewAvatarUrl() {
        return next == null ? null : String.format(AVATAR_URL, getSelfUser().getId(), next, next.startsWith("a_") ? ".gif" : ".png");
    }
}