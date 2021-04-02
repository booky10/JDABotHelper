package tk.booky.jdahelper.api;
// Created by booky10 in JDABotHelper (17:06 27.09.20)

import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import tk.booky.jdahelper.api.exceptions.bot.AlreadyStartedException;
import tk.booky.jdahelper.api.exceptions.bot.NotStartedException;
import tk.booky.jdahelper.api.exceptions.bot.StartException;
import tk.booky.jdahelper.api.utils.JDAHelper;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractJDAMain {

    private ShardManager jda;

    public final void startJDA(String token, List<GatewayIntent> gatewayIntents, List<CacheFlag> cacheFlags) {
        if (hasStarted()) throw new AlreadyStartedException();
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.create(token, gatewayIntents);

        builder.disableCache(Arrays.asList(CacheFlag.values()));
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.addEventListeners(JDAHelper.getListener());
        builder.setEnableShutdownHook(false);
        builder.setUseShutdownNow(true);
        builder.enableCache(cacheFlags);
        builder.setAutoReconnect(true);

        try {
            jda = builder.build();
        } catch (Throwable throwable) {
            throw new StartException(throwable);
        }
    }

    public void shutdown() {
        if (jda == null) throw new NotStartedException();
        jda.shutdown();
    }

    public ShardManager getJDA() {
        if (!hasStarted()) throw new NotStartedException();
        else return jda;
    }

    public boolean hasStarted() {
        return jda != null;
    }
}