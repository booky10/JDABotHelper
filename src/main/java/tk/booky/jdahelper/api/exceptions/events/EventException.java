package tk.booky.jdahelper.api.exceptions.events;
// Created by booky10 in JDABotHelper (20:47 01.03.21)

import tk.booky.jdahelper.api.exceptions.JDAException;

public class EventException extends JDAException {

    public EventException() {
        super();
    }

    public EventException(String message) {
        super(message);
    }

    public EventException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventException(Throwable cause) {
        super(cause);
    }
}