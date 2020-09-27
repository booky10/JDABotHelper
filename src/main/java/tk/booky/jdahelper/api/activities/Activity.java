package tk.booky.jdahelper.api.activities;
// Created by booky10 in JDABotHelper (18:55 27.09.20)

import net.dv8tion.jda.api.sharding.ShardManager;
import tk.booky.jdahelper.internal.manager.Helper;

public final class Activity {

    private final net.dv8tion.jda.api.entities.Activity activity;

    private Activity(net.dv8tion.jda.api.entities.Activity activity) {
        this.activity = activity;
    }

    public final void set(ShardManager jda) {
        Helper.getActivityProvider().setActivity(activity, jda);
    }

    public enum Type {

        CUSTOM(4),
        PLAYING(0),
        WATCHING(3),
        STREAMING(1),
        LISTENING(2);

        private final net.dv8tion.jda.api.entities.Activity.ActivityType type;

        Type(Integer key) {
            this.type = net.dv8tion.jda.api.entities.Activity.ActivityType.fromKey(key);
        }

        public final Activity create(String description) {
            return new Activity(net.dv8tion.jda.api.entities.Activity.of(type, description));
        }

        public final Activity create(String description, String url) {
            return new Activity(net.dv8tion.jda.api.entities.Activity.of(type, description, url));
        }
    }
}