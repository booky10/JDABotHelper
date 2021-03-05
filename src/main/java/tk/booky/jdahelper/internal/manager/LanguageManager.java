package tk.booky.jdahelper.internal.manager;
// Created by booky10 in JDABotHelper (16:47 02.03.21)

import net.dv8tion.jda.api.entities.Guild;
import tk.booky.jdahelper.api.IConfiguration;
import tk.booky.jdahelper.api.manager.ILanguageManager;
import tk.booky.jdahelper.api.provider.ILanguageProvider;
import tk.booky.jdahelper.api.utils.JDAHelper;
import tk.booky.jdahelper.internal.fallback.FallbackLanguageProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LanguageManager implements ILanguageManager {

    private final HashMap<String, ILanguageProvider> languages = new HashMap<>();
    private static final FallbackLanguageProvider FALLBACK_LANGUAGE_PROVIDER = new FallbackLanguageProvider();

    @Override
    public ILanguageProvider getLanguageProvider(String language, ILanguageProvider def) {
        return languages.getOrDefault(language.toLowerCase(), def);
    }

    @Override
    public ILanguageProvider registerLanguageProvider(ILanguageProvider provider) {
        return languages.put(provider.getLanguageID().toLowerCase(), provider);
    }

    @Override
    public ILanguageProvider removeLanguageProvider(String language) {
        return languages.remove(language.toLowerCase());
    }

    @Override
    public List<ILanguageProvider> getLanguageProviders() {
        return Collections.unmodifiableList(new ArrayList<>(languages.values()));
    }

    @Override
    public void clearLanguageProviders() {
        languages.clear();
    }

    @Override
    public ILanguageProvider getDefaultLanguageProvider() {
        return getLanguageProviders().stream().filter(ILanguageProvider::isDefault).findAny().orElse(FALLBACK_LANGUAGE_PROVIDER);
    }

    @Override
    public boolean existsLanguage(String language) {
        return languages.containsKey(language.toLowerCase());
    }

    @Override
    public String getLanguage(Guild guild) {
        IConfiguration<?> configuration = JDAHelper.getConfigurationManager().getConfiguration(guild);
        ILanguageProvider defaultLanguageProvider = getDefaultLanguageProvider();
        return configuration.getString("language", defaultLanguageProvider.getLanguageID());
    }

    @Override
    public ILanguageProvider getLanguageProvider(Guild guild) {
        String language = getLanguage(guild);
        return language == null || !existsLanguage(language) ? null : getLanguageProvider(language);
    }
}