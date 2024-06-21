package com.AppDeck.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ButtonWrapper {
    private Map<String, Button> buttons;

    public Map<String, Button> getButtons() {
        return buttons;
    }

    public void setButtons(Map<String, Button> buttons) {
        this.buttons = buttons;
    }

    public static ButtonWrapper getButtonsWrapper(Map<String, Map<String, String>> buttonsMap) {
        ButtonWrapper buttonsWrapper = new ButtonWrapper();
        Map<String, Button> buttons = new HashMap<>();
        for (Map.Entry<String, Map<String, String>> entry : buttonsMap.entrySet()) {
            String buttonKey = entry.getKey();
            Map<String, String> buttonDetails = entry.getValue();
            Button button = new Button();
            button.setId(buttonKey);
            button.setImage(buttonDetails.get("image"));
            button.setAction(buttonDetails.get("action"));
            button.setPath(buttonDetails.get("path"));
            button.setText(buttonDetails.get("text"));
            buttons.put(buttonKey, button);
        }
        buttonsWrapper.setButtons(buttons);
        return buttonsWrapper;
    }

    public void updateButtons() {
        setButtons(getButtonsWrapper(Objects.requireNonNull(JSONReader.getButtonsMap())).getButtons());
    }
}