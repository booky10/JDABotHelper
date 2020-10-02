package tk.booky.jdahelper.api.event.events.connection;
// Created by booky10 in JDABotHelper (21:43 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.requests.CloseCode;
import tk.booky.jdahelper.api.event.api.Event;

import java.time.OffsetDateTime;

public class ConnectionShutdownEvent extends Event {

    protected final OffsetDateTime shutdownTime;
    protected final Integer code;

    public ConnectionShutdownEvent(JDA jda, OffsetDateTime shutdownTime, Integer code) {
        super(jda);
        this.shutdownTime = shutdownTime;
        this.code = code;
    }

    public CloseCode getCloseCode() {
        return CloseCode.from(code);
    }

    public OffsetDateTime getShutdownTime() {
        return shutdownTime;
    }

    public Integer getCode() {
        return code;
    }
}