package tk.booky.jdahelper.api.event.api;
// Created by booky10 in JDABotHelper (18:41 27.09.20)

public enum EventPriority {

    LOWEST(-1000),
    LOW(-500),
    NORMAL(0),
    HIGH(500),
    HIGHEST(1000);

    private final Integer priority;

    EventPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }
}