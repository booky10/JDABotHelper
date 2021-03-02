package tk.booky.jdahelper.api.exceptions.bot;
// Created by booky10 in JDABotHelper (18:47 27.09.20)

import tk.booky.jdahelper.api.exceptions.JDAException;

public class AlreadyStartedException extends JDAException {

    public AlreadyStartedException() {
    }

    public AlreadyStartedException(String message) {
        super(message);
    }

    public AlreadyStartedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyStartedException(Throwable cause) {
        super(cause);
    }
}