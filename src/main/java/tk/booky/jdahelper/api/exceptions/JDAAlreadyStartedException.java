package tk.booky.jdahelper.api.exceptions;
// Created by booky10 in JDABotHelper (18:47 27.09.20)

public class JDAAlreadyStartedException extends IllegalStateException {

    public JDAAlreadyStartedException() {
    }

    public JDAAlreadyStartedException(String s) {
        super(s);
    }

    public JDAAlreadyStartedException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDAAlreadyStartedException(Throwable cause) {
        super(cause);
    }
}