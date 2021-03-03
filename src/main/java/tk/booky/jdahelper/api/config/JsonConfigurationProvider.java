package tk.booky.jdahelper.api.config;
// Created by booky10 in JDABotHelper (18:27 02.03.21)

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import tk.booky.jdahelper.api.IConfiguration;
import tk.booky.jdahelper.api.exceptions.config.ConfigReadException;
import tk.booky.jdahelper.api.exceptions.config.ConfigWriteException;
import tk.booky.jdahelper.api.exceptions.config.WrongImplementationException;
import tk.booky.jdahelper.api.provider.IConfigurationProvider;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JsonConfigurationProvider implements IConfigurationProvider {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    @Override
    @SuppressWarnings("unchecked")
    public IConfiguration<JsonConfigurationProvider> read(File file) {
        try (FileReader reader = new FileReader(file)) {
            return new JsonConfiguration(gson.fromJson(reader, JsonObject.class));
        } catch (Throwable throwable) {
            throw new ConfigReadException(throwable);
        }
    }

    @Override
    public <T extends IConfigurationProvider> void write(File file, IConfiguration<T> configuration) {
        if (configuration instanceof JsonConfiguration) {
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(((JsonConfiguration) configuration).getJson(), writer);
            } catch (Throwable throwable) {
                throw new ConfigWriteException(throwable);
            }
        } else {
            throw new WrongImplementationException();
        }
    }

    @Override
    public void writeDefault(File file) {
        write(file, new JsonConfiguration());
    }
}