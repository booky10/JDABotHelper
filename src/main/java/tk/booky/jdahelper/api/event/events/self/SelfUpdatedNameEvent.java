package tk.booky.jdahelper.api.event.events.self;
// Created by booky10 in JDABotHelper (21:47 27.09.20)

import net.dv8tion.jda.api.JDA;

public class SelfUpdatedNameEvent extends SelfUpdatedEvent<String> {

    public static final String IDENTIFIER = "name";

    public SelfUpdatedNameEvent(JDA api, Long responseNumber, String oldName) {
        super(api, responseNumber, oldName, api.getSelfUser().getName(), IDENTIFIER);
    }

    public String getOldName() {
        return getOldValue();
    }

    public String getNewName() {
        return getNewValue();
    }
}