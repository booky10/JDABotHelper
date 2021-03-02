package tk.booky.jdahelper.api.manager;
// Created by booky10 in JDABotHelper (16:53 02.03.21)

import net.dv8tion.jda.api.entities.Guild;
import tk.booky.jdahelper.api.IConfiguration;
import tk.booky.jdahelper.api.provider.IConfigurationProvider;

import java.io.File;

public interface IConfigurationManager {

    File getConfigurationFolder();

    IConfigurationProvider getProvider(Class<? extends IConfigurationProvider> clazz);

    <T extends IConfigurationProvider> IConfiguration<T> getConfiguration(Guild guild, T provider);

    File getConfigurationFile(Guild guild);

    IConfigurationProvider getDefaultProvider();
}