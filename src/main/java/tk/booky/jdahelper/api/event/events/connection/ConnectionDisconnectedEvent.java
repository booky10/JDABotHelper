package tk.booky.jdahelper.api.event.events.connection;
// Created by booky10 in JDABotHelper (21:43 27.09.20)

import com.neovisionaries.ws.client.WebSocketFrame;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.requests.CloseCode;
import tk.booky.jdahelper.api.event.api.Event;

import java.time.OffsetDateTime;

public class ConnectionDisconnectedEvent extends Event {

    protected final WebSocketFrame serverCloseFrame, clientCloseFrame;
    protected final Boolean closedByServer;
    protected final OffsetDateTime disconnectTime;

    public ConnectionDisconnectedEvent(JDA jda, WebSocketFrame serverCloseFrame,
                                       WebSocketFrame clientCloseFrame, Boolean closedByServer,
                                       OffsetDateTime disconnectTime) {
        super(jda);

        this.serverCloseFrame = serverCloseFrame;
        this.clientCloseFrame = clientCloseFrame;
        this.closedByServer = closedByServer;
        this.disconnectTime = disconnectTime;
    }

    public CloseCode getCloseCode() {
        return serverCloseFrame == null ? null : CloseCode.from(serverCloseFrame.getCloseCode());
    }

    public WebSocketFrame getServerCloseFrame() {
        return serverCloseFrame;
    }

    public WebSocketFrame getClientCloseFrame() {
        return clientCloseFrame;
    }

    public Boolean getClosedByServer() {
        return closedByServer;
    }

    public OffsetDateTime getDisconnectTime() {
        return disconnectTime;
    }
}