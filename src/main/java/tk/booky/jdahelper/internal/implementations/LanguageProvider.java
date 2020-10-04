package tk.booky.jdahelper.internal.implementations;
// Created by booky10 in JDABotHelper (21:36 04.10.20)

import tk.booky.jdahelper.api.language.ILanguageProvider;

import java.io.File;

public class LanguageProvider implements ILanguageProvider {

    @Override
    public String getLanguage() {
        return null;
    }

    @Override
    public void registerTranslation(String language, String key, String translation) {

    }

    @Override
    public void saveTranslations(File file) {

    }

    @Override
    public String getTranslation(String language, String key) {
        return null;
    }
}