package tk.booky.jdahelper.api.exceptions;
// Created by booky10 in JDABotHelper (19:51 27.09.20)

public class JDALoginException extends IllegalStateException {

    public JDALoginException() {
    }

    public JDALoginException(String s) {
        super(s);
    }

    public JDALoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public JDALoginException(Throwable cause) {
        super(cause);
    }
}