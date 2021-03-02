package tk.booky.jdahelper.api.exceptions.api;
// Created by booky10 in JDABotHelper (17:07 02.03.21)

import tk.booky.jdahelper.api.exceptions.JDAException;

public class ImplementationNotFoundException extends JDAException {

    public ImplementationNotFoundException() {
        super();
    }

    public ImplementationNotFoundException(String message) {
        super(message);
    }

    public ImplementationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImplementationNotFoundException(Throwable cause) {
        super(cause);
    }
}