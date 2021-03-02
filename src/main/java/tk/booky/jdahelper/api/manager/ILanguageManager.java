package tk.booky.jdahelper.api.manager;
// Created by booky10 in JDABotHelper (16:45 02.03.21)

import tk.booky.jdahelper.api.provider.ILanguageProvider;

import java.util.List;

public interface ILanguageManager {

    default ILanguageProvider getLanguageProvider(String language) {
        return getLanguageProvider(language, null);
    }

    ILanguageProvider getLanguageProvider(String language, ILanguageProvider def);

    ILanguageProvider setLanguageProvider(String language, ILanguageProvider provider);

    ILanguageProvider removeLanguageProvider(String language);

    List<ILanguageProvider> getLanguageProviders();

    void clearLanguageProviders();

    ILanguageProvider getDefaultLanguage();

    boolean existsLanguage(String language);
}