package tk.booky.jdahelper.internal.manager;
// Created by booky10 in JDABotHelper (16:55 02.03.21)

import net.dv8tion.jda.api.entities.Guild;
import tk.booky.jdahelper.api.IConfiguration;
import tk.booky.jdahelper.api.config.JsonConfigurationProvider;
import tk.booky.jdahelper.api.exceptions.config.FileNotDirectoryException;
import tk.booky.jdahelper.api.exceptions.config.ProviderInitException;
import tk.booky.jdahelper.api.manager.IConfigurationManager;
import tk.booky.jdahelper.api.provider.IConfigurationProvider;

import java.io.File;
import java.util.HashMap;

public class ConfigurationManager implements IConfigurationManager {

    private static final HashMap<Class<? extends IConfigurationProvider>, IConfigurationProvider> provider = new HashMap<>();
    private static final HashMap<String, IConfiguration<?>> configurations = new HashMap<>();
    private static File configurationFolder = new File(".", "configs");
    private static Class<? extends IConfigurationProvider> defaultProvider = JsonConfigurationProvider.class;

    @Override
    public File getConfigurationFolder() {
        if (!configurationFolder.exists()) configurationFolder.mkdirs();
        return configurationFolder;
    }

    @Override
    public void setConfigurationFolder(File folder) {
        if (folder.exists() && !folder.isDirectory()) throw new FileNotDirectoryException();
        configurationFolder = folder;
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
    public <T extends IConfigurationProvider> IConfiguration<T> getConfiguration(Guild guild, Class<? extends IConfigurationProvider> providerClass) {
        if (!configurations.containsKey(guild.getId())) {
            File file = getConfigurationFile(guild);
            IConfigurationProvider provider = getProvider(providerClass);

            if (!file.exists()) provider.writeDefault(file);
            configurations.put(guild.getId(), provider.read(file));
        }

        return (IConfiguration<T>) configurations.get(guild.getId());
    }

    @Override
    public File getConfigurationFile(Guild guild) {
        return new File(getConfigurationFolder(), guild.getId() + ".json");
    }

    @Override
    public IConfigurationProvider getDefaultProvider() {
        return getProvider(defaultProvider);
    }

    @Override
    public void setDefaultProvider(Class<? extends IConfigurationProvider> provider) {
        defaultProvider = provider;
    }
}