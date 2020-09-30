package tk.booky.jdahelper.api.event.events.category;
// Created by booky10 in JDABotHelper (20:12 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Category;

public class CategoryDeletedEvent  extends CategoryEvent{

    public CategoryDeletedEvent(JDA jda, Long response, Category category) {
        super(jda, response, category);
    }
}