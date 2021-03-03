package tk.booky.jdahelper.api.provider;
// Created by booky10 in JDABotHelper (18:35 04.10.20)

import tk.booky.jdahelper.api.commands.IHelpTranslation;

public interface ILanguageProvider {

    void setTranslation(String key, String translation);

    String getTranslation(String key);

    default String getLanguageID() {
        return getLanguageName().substring(0, 3).toLowerCase();
    }

    String getLanguageName();

    IHelpTranslation getHelpTranslation();

    boolean isDefault();
}