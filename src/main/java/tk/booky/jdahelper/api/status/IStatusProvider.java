package tk.booky.jdahelper.api.status;
// Created by booky10 in JDABotHelper (19:53 27.09.20)

import net.dv8tion.jda.api.sharding.ShardManager;

public interface IStatusProvider {

    void setStatus(Status status, ShardManager jda);
}