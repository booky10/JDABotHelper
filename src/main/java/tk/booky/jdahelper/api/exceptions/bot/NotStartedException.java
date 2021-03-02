package tk.booky.jdahelper.api.exceptions.bot;
// Created by booky10 in JDABotHelper (18:43 27.09.20)

import tk.booky.jdahelper.api.exceptions.JDAException;

public class NotStartedException extends JDAException {

    public NotStartedException() {
    }

    public NotStartedException(String message) {
        super(message);
    }

    public NotStartedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotStartedException(Throwable cause) {
        super(cause);
    }
}