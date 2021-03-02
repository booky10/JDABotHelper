package tk.booky.jdahelper.api.exceptions.bot;
// Created by booky10 in JDABotHelper (19:51 27.09.20)

import tk.booky.jdahelper.api.exceptions.JDAException;

public class StartException extends JDAException {

    public StartException() {
    }

    public StartException(String message) {
        super(message);
    }

    public StartException(String message, Throwable cause) {
        super(message, cause);
    }

    public StartException(Throwable cause) {
        super(cause);
    }
}