package tk.booky.jdahelper.api.exceptions;
// Created by booky10 in JDABotHelper (20:40 01.03.21)

public abstract class JDAException extends IllegalStateException {

    public JDAException() {
        super();
    }

    public JDAException(String message) {
        super(message);
    }

    public JDAException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDAException(Throwable cause) {
        super(cause);
    }
}