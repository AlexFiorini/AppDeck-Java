package com.AppDeck.client;
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
        buttons = ButtonWrapper.getButtonsWrapper(Objects.requireNonNull(JSONReader.getButtonsMap()));
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {
        System.out.println("WebSocket closed: " + session.getRemoteAddress() + ", statusCode: " + statusCode + ", reason: " + reason);
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) {
        buttons.updateButtons();
        Map<String, Button> buttonsMap = buttons.getButtons();
        try {
            for (Map.Entry<String, Button> entry : buttonsMap.entrySet()) {
                if(Objects.equals(entry.getKey(), message)) {
                    Button button = entry.getValue();
                    try {
                        session.getRemote().sendString("The server received the message: " + message);
                        session.getRemote().sendString("Action to do: " + button.getAction());
                    } catch (IOException ignored) {}
                    if(!button.getPath().isEmpty()) {
                        try {
                            Actions.startApp(button.getPath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Actions.mediaAction(button);
                    }
                }
            }
        } catch (Exception ignored){}
    }
}
