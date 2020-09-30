package tk.booky.jdahelper.api.event.events.category;
// Created by booky10 in JDABotHelper (20:12 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Category;

public class CategoryUpdatedNameEvent extends CategoryUpdatedEvent<String> {

    public static final String IDENTIFIER = "name";

    public CategoryUpdatedNameEvent(JDA jda, Long response, Category category, String oldName) {
        super(jda, response, category, oldName, category.getName(), IDENTIFIER);
    }

    public String getOldName() {
        return getOldValue();
    }

    public String getNewName() {
        return getNewValue();
    }
}