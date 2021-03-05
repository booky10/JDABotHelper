package tk.booky.jdahelper.internal.fallback;
// Created by booky10 in JDABotHelper (21:49 05.03.21)

import tk.booky.jdahelper.api.commands.IHelpTranslation;
import tk.booky.jdahelper.api.provider.ILanguageProvider;

public class FallbackLanguageProvider implements ILanguageProvider {

    private static final FallbackHelpTranslation FALLBACK_HELP_TRANSLATION = new FallbackHelpTranslation();

    @Override
    public void setTranslation(String key, String translation) {
    }

    @Override
    public String getTranslation(String key) {
        return key;
    }

    @Override
    public String getLanguageID() {
        return "fb";
    }

    @Override
    public String getLanguageName() {
        return "Fallback";
    }

    @Override
    public IHelpTranslation getHelpTranslation() {
        return FALLBACK_HELP_TRANSLATION;
    }

    @Override
    public boolean isDefault() {
        return false;
    }
}