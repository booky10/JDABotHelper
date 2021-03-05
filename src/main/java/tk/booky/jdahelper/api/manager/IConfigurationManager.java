package tk.booky.jdahelper.api.manager;
// Created by booky10 in JDABotHelper (16:53 02.03.21)

import net.dv8tion.jda.api.entities.Guild;
import tk.booky.jdahelper.api.IConfiguration;
import tk.booky.jdahelper.api.provider.IConfigurationProvider;

import java.io.File;

public interface IConfigurationManager {

    File getConfigurationFolder();

    void setConfigurationFolder(File folder);

    IConfigurationProvider getProvider(Class<? extends IConfigurationProvider> clazz);

    File getConfigurationFile(Guild guild);

    IConfigurationProvider getDefaultProvider();

    void setDefaultProvider(Class<? extends IConfigurationProvider> provider);

    <T extends IConfigurationProvider> IConfiguration<T> getConfiguration(Guild guild, Class<? extends IConfigurationProvider> providerClass);

    default IConfiguration<?> getConfiguration(Guild guild) {
        return getConfiguration(guild, getDefaultProvider().getClass());
    }
}