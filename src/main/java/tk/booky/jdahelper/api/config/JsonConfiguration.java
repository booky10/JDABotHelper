package tk.booky.jdahelper.api.config;
// Created by booky10 in JDABotHelper (21:49 01.03.21)

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import tk.booky.jdahelper.api.IConfiguration;
import tk.booky.jdahelper.api.utils.JDAHelper;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class JsonConfiguration implements IConfiguration<JsonConfigurationProvider> {

    private final JsonObject json;

    public JsonConfiguration() {
        this(new JsonObject());
    }

    public JsonConfiguration(JsonObject json) {
        this.json = json;
    }

    @Override
    public Object get(String path, Object def) {
        return contains(path) ? json.get(path) : def;
    }

    @Override
    public String getString(String path, String def) {
        return contains(path) ? json.getAsJsonPrimitive(path).getAsString() : def;
    }

    @Override
    public int getInt(String path, int def) {
        return contains(path) ? json.getAsJsonPrimitive(path).getAsInt() : def;
    }

    @Override
    public double getDouble(String path, double def) {
        return contains(path) ? json.getAsJsonPrimitive(path).getAsDouble() : def;
    }

    @Override
    public float getFloat(String path, float def) {
        return contains(path) ? json.getAsJsonPrimitive(path).getAsFloat() : def;
    }

    @Override
    public long getLong(String path, long def) {
        return contains(path) ? json.getAsJsonPrimitive(path).getAsLong() : def;
    }

    @Override
    public short getShort(String path, short def) {
        return contains(path) ? json.getAsJsonPrimitive(path).getAsShort() : def;
    }

    @Override
    public byte getByte(String path, byte def) {
        return contains(path) ? json.getAsJsonPrimitive(path).getAsByte() : def;
    }

    @Override
    public boolean getBoolean(String path, boolean def) {
        return contains(path) ? json.getAsJsonPrimitive(path).getAsBoolean() : def;
    }

    @Override
    public char getCharacter(String path, char def) {
        return contains(path) ? json.getAsJsonPrimitive(path).getAsCharacter() : def;
    }

    @Override
    public List<Object> getList(String path, List<Object> def) {
        return contains(path) ? StreamSupport.stream(json.getAsJsonArray(path).spliterator(), false).collect(Collectors.toList()) : def;
    }

    @Override
    public List<String> getStringList(String path, List<String> def) {
        return contains(path) ? StreamSupport.stream(json.getAsJsonArray(path).spliterator(), false).map(JsonElement::getAsString).collect(Collectors.toList()) : def;
    }

    @Override
    public boolean contains(String path) {
        return json.has(path);
    }

    @Override
    public void set(String path, Object object) {
        remove(path);

        if (object instanceof JsonElement) {
            json.add(path, (JsonElement) object);
        } else if (object instanceof Number) {
            json.addProperty(path, (Number) object);
        } else if (object instanceof String) {
            json.addProperty(path, (String) object);
        } else if (object instanceof Boolean) {
            json.addProperty(path, (Boolean) object);
        } else if (object instanceof Character) {
            json.addProperty(path, (Character) object);
        } else {
            throw new IllegalArgumentException(object.toString());
        }
    }

    @Override
    public void remove(String path) {
        if (contains(path)) json.remove(path);
    }

    @Override
    public void save(File file) {
        JDAHelper.getConfigurationManager().getProvider(JsonConfigurationProvider.class).write(file, this);
    }

    public JsonObject getJson() {
        return json;
    }
}