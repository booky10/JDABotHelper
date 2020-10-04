package tk.booky.jdahelper.api.event.events.category;
// Created by booky10 in JDABotHelper (21:58 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.Guild;
import tk.booky.jdahelper.api.event.api.Event;

public class CategoryEvent extends Event {

    protected final Category category;

    public CategoryEvent(JDA jda, Long response, Category category) {
        super(jda, response);

        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public String getID() {
        return Long.toUnsignedString(getIDLong());
    }

    public Long getIDLong() {
        return getCategory().getIdLong();
    }

    public Guild getGuild() {
        return getCategory().getGuild();
    }
}