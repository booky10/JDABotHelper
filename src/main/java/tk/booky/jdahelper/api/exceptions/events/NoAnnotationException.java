package tk.booky.jdahelper.api.exceptions.events;
// Created by booky10 in JDABotHelper (21:10 01.03.21)

import tk.booky.jdahelper.api.exceptions.JDAException;

public class NoAnnotationException extends JDAException {

    public NoAnnotationException() {
        super();
    }

    public NoAnnotationException(String message) {
        super(message);
    }

    public NoAnnotationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAnnotationException(Throwable cause) {
        super(cause);
    }
}