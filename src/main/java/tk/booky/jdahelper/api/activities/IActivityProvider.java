package tk.booky.jdahelper.api.activities;
// Created by booky10 in JDABotHelper (18:50 27.09.20)

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.ShardManager;

public interface IActivityProvider {

    void setActivity(Activity activity, ShardManager jda);
}