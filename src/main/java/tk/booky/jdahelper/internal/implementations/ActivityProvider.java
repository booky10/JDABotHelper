package tk.booky.jdahelper.internal.implementations;
// Created by booky10 in JDABotHelper (18:51 27.09.20)

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.ShardManager;
import tk.booky.jdahelper.api.activities.IActivityProvider;

public class ActivityProvider implements IActivityProvider {

    @Override
    public void setActivity(Activity activity, ShardManager jda) {
        jda.setActivity(activity);
    }
}