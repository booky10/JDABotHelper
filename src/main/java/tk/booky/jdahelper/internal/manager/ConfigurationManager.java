package tk.booky.jdahelper.internal.manager;
// Created by booky10 in JDABotHelper (16:55 02.03.21)

import net.dv8tion.jda.api.entities.Guild;
import tk.booky.jdahelper.api.IConfiguration;
import tk.booky.jdahelper.api.config.JsonConfigurationProvider;
import tk.booky.jdahelper.api.exceptions.config.ProviderInitException;
import tk.booky.jdahelper.api.manager.IConfigurationManager;
import tk.booky.jdahelper.api.provider.IConfigurationProvider;

import java.io.File;
import java.util.HashMap;

public class ConfigurationManager implements IConfigurationManager {

    private static final HashMap<Class<? extends IConfigurationProvider>, IConfigurationProvider> provider = new HashMap<>();
    private static final HashMap<String, IConfiguration<?>> configurations = new HashMap<>();
    private static final File configurationFolder = new File(".", "configs");

    static {
        provider.put(JsonConfigurationProvider.class, new JsonConfigurationProvider());
    }

    @Override
    public File getConfigurationFolder() {
        return configurationFolder;
    }

    @Override
    public IConfigurationProvider getProvider(Class<? extends IConfigurationProvider> clazz) {
        if (!provider.containsKey(clazz)) {
            try {
                provider.put(clazz, clazz.newInstance());
            } catch (Throwable throwable) {
                throw new ProviderInitException(throwable);
            }
        }

        return provider.get(clazz);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends IConfigurationProvider> IConfiguration<T> getConfiguration(Guild guild, T provider) {
        if (!configurations.containsKey(guild.getId())) {
            File file = getConfigurationFile(guild);
            if (!file.exists()) provider.writeDefault(file);

            configurations.put(guild.getId(), provider.read(file));
        }

        return (IConfiguration<T>) configurations.get(guild.getId());
    }

    @Override
    public IConfiguration<?> getConfiguration(Guild guild) {
        return getConfiguration(guild, getDefaultProvider());
    }

    @Override
    public File getConfigurationFile(Guild guild) {
        return new File(getConfigurationFolder(), guild.getId() + ".json");
    }

    @Override
    public IConfigurationProvider getDefaultProvider() {
        return provider.values().stream().filter(IConfigurationProvider::isDefault).findAny().orElse(null);
    }
}