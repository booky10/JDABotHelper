package tk.booky.jdahelper.api.manager;
// Created by booky10 in JDABotHelper (16:45 02.03.21)

import net.dv8tion.jda.api.entities.Guild;
import tk.booky.jdahelper.api.provider.ILanguageProvider;

import java.util.List;

public interface ILanguageManager {

    default ILanguageProvider getLanguageProvider(String language) {
        return getLanguageProvider(language, null);
    }

    ILanguageProvider getLanguageProvider(String language, ILanguageProvider def);

    ILanguageProvider registerLanguageProvider(ILanguageProvider provider);

    ILanguageProvider removeLanguageProvider(String language);

    List<ILanguageProvider> getLanguageProviders();

    void clearLanguageProviders();

    ILanguageProvider getDefaultLanguageProvider();

    boolean existsLanguage(String language);

    String getLanguage(Guild guild);

    ILanguageProvider getLanguageProvider(Guild guild);
}