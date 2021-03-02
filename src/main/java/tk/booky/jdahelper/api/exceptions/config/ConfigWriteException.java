package tk.booky.jdahelper.api.exceptions.config;
// Created by booky10 in JDABotHelper (22:01 01.03.21)

import tk.booky.jdahelper.api.exceptions.JDAException;

public class ConfigWriteException extends JDAException {

    public ConfigWriteException() {
        super();
    }

    public ConfigWriteException(String message) {
        super(message);
    }

    public ConfigWriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigWriteException(Throwable cause) {
        super(cause);
    }
}