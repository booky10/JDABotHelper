package tk.booky.jdahelper.api.status;
// Created by booky10 in JDABotHelper (19:52 27.09.20)

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.sharding.ShardManager;
import tk.booky.jdahelper.internal.Helper;

import java.util.Objects;

public final class Status {

    private final Type type;

    private Status(Type type) {
        this.type = type;
    }

    public final Type getType() {
        return type;
    }

    public static Status fromJDA(OnlineStatus status) {
        return Objects.requireNonNull(Type.fromKey(status.getKey())).getStatus();
    }

    public void set(ShardManager jda) {
        Helper.getStatusProvider().setStatus(this, jda);
    }

    public enum Type {

        INVISIBLE("invisible"),
        DO_NOT_DISTURB("dnd"),
        OFFLINE("offline"),
        ONLINE("online"),
        IDLE("idle"),
        UNKNOWN("");

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

        public static Type fromKey(String key) {
            for (Type type : values()) if (type.key.equals(key)) return type;
            for (Type type : values()) if (type.key.equalsIgnoreCase(key)) return type;
            return null;
        }
    }
}