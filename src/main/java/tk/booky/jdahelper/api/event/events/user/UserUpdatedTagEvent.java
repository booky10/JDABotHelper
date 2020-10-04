package tk.booky.jdahelper.api.event.events.user;
// Created by booky10 in JDABotHelper (21:31 04.10.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;

public class UserUpdatedTagEvent extends UserUpdatedEvent<String> {

    public static final String IDENTIFIER = "discriminator";

    public UserUpdatedTagEvent(JDA jda, Long response, User user, String oldTag) {
        super(jda, response, user, oldTag, user.getDiscriminator(), IDENTIFIER);
    }

    public String getOldTag() {
        return getOldValue();
    }

    public String getNewTag() {
        return getNewValue();
    }
}