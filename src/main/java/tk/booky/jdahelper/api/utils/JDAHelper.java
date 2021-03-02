package tk.booky.jdahelper.api.utils;
// Created by booky10 in JDABotHelper (18:50 27.09.20)

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.RestAction;
import tk.booky.jdahelper.api.exceptions.api.ImplementationNotFoundException;
import tk.booky.jdahelper.api.manager.*;

import java.awt.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JDAHelper {

    private static final IImplementationManager manager;

    static {
        try {
            manager = (IImplementationManager) Class.forName("tk.booky.jdahelper.internal.manager.ImplementationManager").newInstance();
        } catch (Throwable throwable) {
            throw new ImplementationNotFoundException(throwable);
        }
    }

    public static ListenerAdapter getListener() {
        return manager.getListener();
    }

    public static ICommandManager getCommandManager() {
        return manager.getCommandManager();
    }

    public static ILanguageManager getLanguageManager() {
        return manager.getLanguageManager();
    }

    public static IEventManager getEventManager() {
        return manager.getEventManager();
    }

    public static IConfigurationManager getConfigurationManager() {
        return manager.getConfigurationManager();
    }

    public static IImplementationManager getImplementationManager() {
        return manager;
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