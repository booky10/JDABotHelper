package tk.booky.jdahelper.internal;
// Created by booky10 in JDABotHelper (18:50 27.09.20)

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.RestAction;
import tk.booky.jdahelper.api.commands.ICommandManager;
import tk.booky.jdahelper.api.event.AbstractEventManager;
import tk.booky.jdahelper.api.language.ILanguageProvider;
import tk.booky.jdahelper.internal.events.EventManager;
import tk.booky.jdahelper.internal.events.Listener;
import tk.booky.jdahelper.internal.implementations.CommandManager;
import tk.booky.jdahelper.internal.implementations.LanguageProvider;
import tk.booky.jdahelper.utils.Pair;

import java.awt.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Helper {

    private static ILanguageProvider languageProvider;
    private static ICommandManager commandManager;
    private static AbstractEventManager eventManager;
    private static Listener listener;

    public static Listener getListener() {
        if (listener == null) listener = new Listener();
        return listener;
    }

    public static ICommandManager getCommandManager() {
        if (commandManager == null) commandManager = new CommandManager();
        return commandManager;
    }

    public static ILanguageProvider getLanguageProvider() {
        if (languageProvider == null) languageProvider = new LanguageProvider();
        return languageProvider;
    }

    public static AbstractEventManager getEventManager() {
        if (eventManager == null) eventManager = new EventManager();
        return eventManager;
    }

    @SafeVarargs
    public static RestAction<Message> sendEmbed(MessageChannel channel, String title, String body, Pair<String, String>... fields) {
        return sendEmbed(channel, new Color((int) (Math.random() * 0x1000000)), title, body, true, fields);
    }

    public static RestAction<Message> sendEmbed(MessageChannel channel, String title, String body, List<Pair<String, String>> fields) {
        return sendEmbed(channel, new Color((int) (Math.random() * 0x1000000)), title, body, true, fields);
    }

    @SafeVarargs
    public static RestAction<Message> sendEmbed(MessageChannel channel, Color color, String title, String body, Pair<String, String>... fields) {
        return sendEmbed(channel, color, title, body, true, fields);
    }

    public static RestAction<Message> sendEmbed(MessageChannel channel, Color color, String title, String body, List<Pair<String, String>> fields) {
        return sendEmbed(channel, color, title, body, true, fields);
    }

    @SafeVarargs
    public static RestAction<Message> sendEmbed(MessageChannel channel, Color color, String title, String body, Boolean inLine, Pair<String, String>... fields) {
        return sendEmbed(channel, color, title, body, inLine, Arrays.asList(fields));
    }

    public static RestAction<Message> sendEmbed(MessageChannel channel, Color color, String title, String body, Boolean inLine, List<Pair<String, String>> fields) {
        EmbedBuilder builder = new EmbedBuilder();

        builder.setTitle(title);
        builder.setDescription(body);
        builder.setColor(color.getRGB());
        builder.setTimestamp(new Date(System.currentTimeMillis()).toInstant());

        fields.forEach(field -> builder.addField(field.getKey(), field.getValue(), inLine));

        if (channel.getType().isGuild()) {
            Guild guild = ((GuildChannel) channel).getGuild();
            builder.setFooter(guild.getName(), guild.getIconUrl());
        } else if (channel.getType().equals(ChannelType.PRIVATE)) {
            User user = ((PrivateChannel) channel).getUser();
            builder.setFooter(user.getAsTag(), user.getEffectiveAvatarUrl());
        } else {
            builder.setFooter(channel.getName());
        }

        return channel.sendMessage(builder.build());
    }
}