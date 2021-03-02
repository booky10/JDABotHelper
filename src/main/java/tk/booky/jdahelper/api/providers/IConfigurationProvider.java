package tk.booky.jdahelper.api.providers;
// Created by booky10 in JDABotHelper (21:49 01.03.21)

import java.io.File;
import java.util.List;

public interface IConfigurationProvider {

    void read(File file);

    void write(File file);

    default Object get(String path) {
        return get(path, null);
    }

    Object get(String path, Object def);

    default String getString(String path) {
        return getString(path, null);
    }

    String getString(String path, String def);

    default int getInt(String path) {
        return getInt(path, 0);
    }

    int getInt(String path, int def);

    default double getDouble(String path) {
        return getDouble(path, 0);
    }

    double getDouble(String path, double def);

    default float getFloat(String path) {
        return getFloat(path, 0);
    }

    float getFloat(String path, float def);

    default long getLong(String path) {
        return getLong(path, 0);
    }

    long getLong(String path, long def);

    default short getShort(String path) {
        return getShort(path, (short) 0);
    }

    short getShort(String path, short def);

    default byte getByte(String path) {
        return getByte(path, (byte) 0);
    }

    byte getByte(String path, byte def);

    default boolean getBoolean(String path) {
        return getBoolean(path, false);
    }

    boolean getBoolean(String path, boolean def);

    default char getCharacter(String path) {
        return getCharacter(path, ' ');
    }

    char getCharacter(String path, char def);

    default List<Object> getList(String path) {
        return getList(path, null);
    }

    List<Object> getList(String path, List<Object> def);

    default List<String> getStringList(String path) {
        return getStringList(path, null);
    }

    List<String> getStringList(String path, List<String> def);

    boolean contains(String path);
}