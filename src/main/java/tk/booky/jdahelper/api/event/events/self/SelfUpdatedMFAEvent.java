package tk.booky.jdahelper.api.event.events.self;
// Created by booky10 in JDABotHelper (21:46 27.09.20)

import net.dv8tion.jda.api.JDA;

import javax.annotation.Nonnull;

public class SelfUpdatedMFAEvent extends SelfUpdatedEvent<Boolean> {

    public static final String IDENTIFIER = "mfa_enabled";

    public SelfUpdatedMFAEvent(JDA api, Long responseNumber, Boolean wasMFAEnabled) {
        super(api, responseNumber, wasMFAEnabled, !wasMFAEnabled, IDENTIFIER);
    }

    public boolean wasMFAEnabled()
    {
        return getOldValue();
    }

    @Override
    public Boolean getOldValue()
    {
        return super.getOldValue();
    }

    @Override
    public Boolean getNewValue()
    {
        return super.getNewValue();
    }
}