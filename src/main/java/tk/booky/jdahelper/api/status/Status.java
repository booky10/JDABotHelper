package tk.booky.jdahelper.api.status;
// Created by booky10 in JDABotHelper (19:52 27.09.20)

public final class Status {

    private final Type type;

    private Status(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {

        INVISIBLE("invisible"),
        DO_NOT_DISTURB("dnd"),
        OFFLINE("offline"),
        ONLINE("online"),
        IDLE("idle");

        private final String key;

        Type(String key) {
            this.key = key;
        }

        public final String getKey() {
            return key;
        }

        public final Status getStatus() {
            return new Status(this);
        }
    }
}