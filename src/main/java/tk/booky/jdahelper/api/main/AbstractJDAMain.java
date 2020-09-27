package tk.booky.jdahelper.api.main;
// Created by booky10 in JDABotHelper (17:06 27.09.20)

import net.dv8tion.jda.api.sharding.ShardManager;
import tk.booky.jdahelper.api.exceptions.JDANotStartedException;

public abstract class AbstractJDAMain {

    private ShardManager jda;

    protected final void startJDA(String token) {

    }

    public final ShardManager getJDA() {
        if (jda == null) throw new JDANotStartedException("JDA is not started or crashed!");
        return jda;
    }
}