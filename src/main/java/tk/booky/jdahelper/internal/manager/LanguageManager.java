package tk.booky.jdahelper.internal.manager;
// Created by booky10 in JDABotHelper (16:47 02.03.21)

import org.jetbrains.annotations.Nullable;
import tk.booky.jdahelper.api.manager.ILanguageManager;
import tk.booky.jdahelper.api.provider.ILanguageProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LanguageManager implements ILanguageManager {

    private final HashMap<String, ILanguageProvider> languages = new HashMap<>();

    @Override
    public ILanguageProvider getLanguageProvider(String language, ILanguageProvider def) {
        return languages.getOrDefault(language.toLowerCase(), def);
    }

    @Override
    public ILanguageProvider setLanguageProvider(String language, ILanguageProvider provider) {
        return languages.put(language.toLowerCase(), provider);
    }

    @Override
    public ILanguageProvider removeLanguageProvider(String language) {
        return languages.remove(language.toLowerCase());
    }

    @Override
    public List<ILanguageProvider> getLanguageProviders() {
        return new ArrayList<>(languages.values());
    }

    @Override
    public void clearLanguageProviders() {
        languages.clear();
    }

    @Nullable
    @Override
    public ILanguageProvider getDefaultLanguage() {
        return getLanguageProviders().stream().filter(ILanguageProvider::isDefault).findAny().orElse(null);
    }

    @Override
    public boolean existsLanguage(String language) {
        return languages.containsKey(language.toLowerCase());
    }
}