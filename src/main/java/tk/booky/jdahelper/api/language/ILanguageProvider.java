package tk.booky.jdahelper.api.language;
// Created by booky10 in JDABotHelper (18:35 04.10.20)

import java.io.File;

public interface ILanguageProvider {

    String getLanguage();

    void registerTranslation(String language, String key, String translation);

    void saveTranslations(File file);

    String getTranslation(String language, String key);

    default String getTranslation(String key) {
        return getTranslation(getLanguage(), key);
    }
}