package tk.booky.jdahelper.api.exceptions.events;
// Created by booky10 in JDABotHelper (21:03 01.03.21)

import tk.booky.jdahelper.api.exceptions.JDAException;

public class ListenerRegisterException extends JDAException {

    public ListenerRegisterException() {
        super();
    }

    public ListenerRegisterException(String message) {
        super(message);
    }

    public ListenerRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListenerRegisterException(Throwable cause) {
        super(cause);
    }
}