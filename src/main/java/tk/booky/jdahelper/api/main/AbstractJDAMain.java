package tk.booky.jdahelper.api.main;
// Created by booky10 in JDABotHelper (17:06 27.09.20)

import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import tk.booky.jdahelper.api.exceptions.AlreadyStartedException;
import tk.booky.jdahelper.api.exceptions.LoginException;
import tk.booky.jdahelper.api.exceptions.NotStartedException;
import tk.booky.jdahelper.internal.Helper;

import java.util.Arrays;

public abstract class AbstractJDAMain {

    private ShardManager jda;

    protected final void startJDA(String token) {
        if (jda != null) throw new AlreadyStartedException("JDA is already started!");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.create(token, Arrays.asList(GatewayIntent.values()));
        builder.enableCache(Arrays.asList(CacheFlag.values()));
        builder.addEventListeners(Helper.getListener());
        builder.setAutoReconnect(true);
        builder.setEnableShutdownHook(false);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setUseShutdownNow(true);

        try {
            jda = builder.build();
        } catch (javax.security.auth.login.LoginException exception) {
            throw new LoginException(exception);
        }
    }

    protected final void shutdown() {
        if (jda == null) throw new NotStartedException("JDA is not started or crashed!");
        jda.shutdown();
    }

    public final ShardManager getJDA() {
        if (jda == null) throw new NotStartedException("JDA is not started or crashed!");
        return jda;
    }
}