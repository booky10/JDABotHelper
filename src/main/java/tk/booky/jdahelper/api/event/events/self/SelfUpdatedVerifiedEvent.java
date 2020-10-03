package tk.booky.jdahelper.api.event.events.self;
// Created by booky10 in JDABotHelper (21:47 27.09.20)

import net.dv8tion.jda.api.JDA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelfUpdatedVerifiedEvent extends SelfUpdatedEvent<Boolean> {

    public static final String IDENTIFIER = "verified";

    public SelfUpdatedVerifiedEvent(JDA jda, Long response, boolean wasVerified) {
        super(jda, response, wasVerified, !wasVerified, IDENTIFIER);

        Logger logger = LoggerFactory.getLogger("Verified");
        if (!wasVerified) logger.info("You're bot has just been verified! GG!");
        else logger.info("OK, how did you're bot get unverified? Just tell me that!");
    }
}