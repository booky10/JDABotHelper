package tk.booky.jdahelper.internal.provider;
// Created by booky10 in JDABotHelper (21:49 01.03.21)

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import tk.booky.jdahelper.api.exceptions.config.ConfigReadException;
import tk.booky.jdahelper.api.exceptions.config.ConfigWriteException;
import tk.booky.jdahelper.api.provider.IConfigurationProvider;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class JSONConfigProvider implements IConfigurationProvider {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private JsonObject object = new JsonObject();

    @Override
    public void read(File file) {
        try (FileReader reader = new FileReader(file)) {
            object = gson.fromJson(reader, JsonObject.class);
        } catch (Throwable throwable) {
            throw new ConfigReadException(throwable);
        }
    }

    @Override
    public void write(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(object, writer);
        } catch (Throwable throwable) {
            throw new ConfigWriteException(throwable);
        }
    }

    @Override
    public Object get(String path, Object def) {
        return contains(path) ? object.get(path) : def;
    }

    @Override
    public String getString(String path, String def) {
        return contains(path) ? object.getAsJsonPrimitive(path).getAsString() : def;
    }

    @Override
    public int getInt(String path, int def) {
        return contains(path) ? object.getAsJsonPrimitive(path).getAsInt() : def;
    }

    @Override
    public double getDouble(String path, double def) {
        return contains(path) ? object.getAsJsonPrimitive(path).getAsDouble() : def;
    }

    @Override
    public float getFloat(String path, float def) {
        return contains(path) ? object.getAsJsonPrimitive(path).getAsFloat() : def;
    }

    @Override
    public long getLong(String path, long def) {
        return contains(path) ? object.getAsJsonPrimitive(path).getAsLong() : def;
    }

    @Override
    public short getShort(String path, short def) {
        return contains(path) ? object.getAsJsonPrimitive(path).getAsShort() : def;
    }

    @Override
    public byte getByte(String path, byte def) {
        return contains(path) ? object.getAsJsonPrimitive(path).getAsByte() : def;
    }

    @Override
    public boolean getBoolean(String path, boolean def) {
        return contains(path) ? object.getAsJsonPrimitive(path).getAsBoolean() : def;
    }

    @Override
    public char getCharacter(String path, char def) {
        return contains(path) ? object.getAsJsonPrimitive(path).getAsCharacter() : def;
    }

    @Override
    public List<Object> getList(String path, List<Object> def) {
        return contains(path) ? StreamSupport.stream(object.getAsJsonArray(path).spliterator(), false).collect(Collectors.toList()) : def;
    }

    @Override
    public List<String> getStringList(String path, List<String> def) {
        return contains(path) ? StreamSupport.stream(object.getAsJsonArray(path).spliterator(), false).map(JsonElement::getAsString).collect(Collectors.toList()) : def;
    }

    @Override
    public boolean contains(String path) {
        return object.has(path);
    }
}