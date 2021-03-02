package tk.booky.jdahelper.api.provider;
// Created by booky10 in JDABotHelper (21:49 01.03.21)

import tk.booky.jdahelper.api.IConfiguration;

import java.io.File;

public interface IConfigurationProvider {

    <T extends IConfigurationProvider> IConfiguration<T> read(File file);

    <T extends IConfigurationProvider> void write(File file, IConfiguration<T> configuration);

    void writeDefault(File file);
}