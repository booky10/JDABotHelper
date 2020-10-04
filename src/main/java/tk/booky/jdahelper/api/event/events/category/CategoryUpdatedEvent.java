package tk.booky.jdahelper.api.event.events.category;
// Created by booky10 in JDABotHelper (21:58 30.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Category;
import org.jetbrains.annotations.NotNull;
import tk.booky.jdahelper.api.event.api.IUpdateEvent;

public class CategoryUpdatedEvent<T> extends CategoryEvent implements IUpdateEvent<Category, T> {

    protected final T previous, next;
    protected final String identifier;

    public CategoryUpdatedEvent(JDA jda, Long response, Category category, T previous, T next, String identifier) {
        super(jda, response, category);

        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    @Override
    public @NotNull Category getEntity() {
        return getCategory();
    }

    @Override
    public T getOldValue() {
        return previous;
    }

    @Override
    public T getNewValue() {
        return next;
    }

    @Override
    public @NotNull String getPropertyIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return "CategoryUpdate[" + getPropertyIdentifier() + "](" + getOldValue() + "->" + getNewValue() + ')';
    }
}