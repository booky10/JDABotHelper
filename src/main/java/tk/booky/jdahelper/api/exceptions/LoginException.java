package tk.booky.jdahelper.api.exceptions;
// Created by booky10 in JDABotHelper (19:51 27.09.20)

public class LoginException extends JDAException {

    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }
}