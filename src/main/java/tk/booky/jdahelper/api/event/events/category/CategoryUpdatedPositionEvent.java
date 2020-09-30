package tk.booky.jdahelper.api.event.events.category;
// Created by booky10 in JDABotHelper (20:12 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Category;

public class CategoryUpdatedPositionEvent extends CategoryUpdatedEvent<Integer> {

    public static final String IDENTIFIER = "position";

    public CategoryUpdatedPositionEvent(JDA jda, Long response, Category category, Integer oldPosition) {
        super(jda, response, category, oldPosition, category.getPositionRaw(), IDENTIFIER);
    }

    public Integer getOldPosition() {
        return getOldValue();
    }

    public Integer getNewPosition() {
        return getNewValue();
    }
}