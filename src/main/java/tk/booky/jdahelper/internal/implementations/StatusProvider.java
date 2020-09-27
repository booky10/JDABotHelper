package tk.booky.jdahelper.internal.implementations;
// Created by booky10 in JDABotHelper (19:53 27.09.20)

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.sharding.ShardManager;
import tk.booky.jdahelper.api.status.IStatusProvider;
import tk.booky.jdahelper.api.status.Status;

public class StatusProvider implements IStatusProvider {

    @Override
    public void setStatus(Status status, ShardManager jda) {
        jda.setStatus(OnlineStatus.fromKey(status.getType().getKey()));
    }
}