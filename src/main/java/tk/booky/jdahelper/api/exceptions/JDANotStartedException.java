package tk.booky.jdahelper.api.exceptions;
// Created by booky10 in JDABotHelper (18:43 27.09.20)

public class JDANotStartedException extends IllegalStateException {

    public JDANotStartedException() {
    }

    public JDANotStartedException(String s) {
        super(s);
    }

    public JDANotStartedException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDANotStartedException(Throwable cause) {
        super(cause);
    }
}