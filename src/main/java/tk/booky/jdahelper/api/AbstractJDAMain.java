package tk.booky.jdahelper.api;
// Created by booky10 in JDABotHelper (17:06 27.09.20)

import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.internal.utils.JDALogger;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import tk.booky.jdahelper.api.exceptions.bot.AlreadyStartedException;
import tk.booky.jdahelper.api.exceptions.bot.StartException;
import tk.booky.jdahelper.api.exceptions.bot.NotStartedException;
import tk.booky.jdahelper.api.utils.JDAHelper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractJDAMain {

    protected static Logger logger = JDALogger.getLog(AbstractJDAMain.class);
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

            logger.info("Bot Information");
            logger.info("");

            logger.info("     User Count: " + jda.getUsers().size());
            logger.info("     Role Count: " + jda.getRoles().size());
            logger.info("    Guild Count: " + jda.getGuilds().size());
            logger.info("    Emote Count: " + jda.getEmotes().size());
            logger.info("    Shard Count: " + jda.getShardsRunning() + "/" + jda.getShardsTotal() + " (Queued: " + jda.getShardsQueued() + ")");
            logger.info("   Average Ping: " + jda.getAverageGatewayPing());
            logger.info("Gateway Intents: " + jda.getGatewayIntents().stream().map(gatewayIntent -> StringUtils.capitalize(gatewayIntent.name().toLowerCase())).collect(Collectors.joining(", ")));

            logger.info("");
            logger.info("Private Channel Count: " + jda.getPrivateChannels().size());
            logger.info("  Store Channel Count: " + jda.getStoreChannels().size());
            logger.info("  Voice Channel Count: " + jda.getVoiceChannels().size());
            logger.info("   Text Channel Count: " + jda.getTextChannels().size());
            logger.info("       Category Count: " + jda.getCategories().size());

            logger.info("");
            logger.info("All Channel Count: " + (jda.getPrivateChannels().size() + jda.getStoreChannels().size() + jda.getVoiceChannels().size() + jda.getTextChannels().size() + jda.getCategories().size()));
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