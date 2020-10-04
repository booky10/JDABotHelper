package tk.booky.jdahelper.api.event.events.gateway;
// Created by booky10 in JDABotHelper (21:41 27.09.20)

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.utils.data.DataObject;
import tk.booky.jdahelper.api.event.api.Event;

public class GatewayEvent extends Event {

    private final DataObject data;

    public GatewayEvent(JDA jda, Long response, DataObject data) {
        super(jda, response);

        this.data = data;
    }

    public DataObject getPackage() {
        return data;
    }

    public DataObject getPayload() {
        return data.getObject("d");
    }

    public String getType() {
        return data.getString("t");
    }
}