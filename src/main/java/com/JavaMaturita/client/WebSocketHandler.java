package com.JavaMaturita.client;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@WebSocket
public class WebSocketHandler {
    ButtonWrapper buttons;
    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.println("WebSocket connected: " + session.getRemoteAddress());
        buttons = JSONReader.getButtons();
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {
        System.out.println("WebSocket closed: " + session.getRemoteAddress() + ", statusCode: " + statusCode + ", reason: " + reason);
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) {
        Map<String, Button> buttonsMap = buttons.getButtons();
        for (Map.Entry<String, Button> entry : buttonsMap.entrySet()) {
            if(Objects.equals(entry.getKey(), message)) {
                Button button = entry.getValue();
                if(!button.getPath().isEmpty()) {
                    try {
                        Actions.startApp(button.getPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Actions.mediaAction(button);
                }
                try {
                    session.getRemote().sendString("The server received the message: " + message);
                } catch (IOException ignored) {}
            }
        }
    }
}
