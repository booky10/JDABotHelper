package tk.booky.jdahelper.api.activities;
// Created by booky10 in JDABotHelper (18:55 27.09.20)

import net.dv8tion.jda.api.sharding.ShardManager;
import tk.booky.jdahelper.internal.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Activity {

    private final net.dv8tion.jda.api.entities.Activity activity;

    private Activity(net.dv8tion.jda.api.entities.Activity activity) {
        this.activity = activity;
    }

    public final void set(ShardManager jda) {
        Helper.getActivityProvider().setActivity(activity, jda);
    }

    public static Activity fromJDA(net.dv8tion.jda.api.entities.Activity activity) {
        Type type = Objects.requireNonNull(Type.fromKey(activity.getType().getKey()));
        return type.create(activity.getName(), activity.getUrl());
    }

    public static List<Activity> fromJDA(List<net.dv8tion.jda.api.entities.Activity> activities) {
        List<Activity> processedActivities = new ArrayList<>();
        for (net.dv8tion.jda.api.entities.Activity activity : activities)
            processedActivities.add(fromJDA(activity));
        return processedActivities;
    }

    public enum Type {

        CUSTOM(4),
        PLAYING(0),
        WATCHING(3),
        STREAMING(1),
        LISTENING(2);

        private final net.dv8tion.jda.api.entities.Activity.ActivityType type;
        private final Integer key;

        Type(Integer key) {
            this.key = key;
            type = net.dv8tion.jda.api.entities.Activity.ActivityType.fromKey(key);
        }

        public final Activity create(String description) {
            return new Activity(net.dv8tion.jda.api.entities.Activity.of(type, description));
        }

        public final Activity create(String description, String url) {
            return new Activity(net.dv8tion.jda.api.entities.Activity.of(type, description, url));
        }

        public static Type fromKey(Integer key) {
            for (Type type : values()) if (key.equals(type.key)) return type;
            return null;
        }
    }
}