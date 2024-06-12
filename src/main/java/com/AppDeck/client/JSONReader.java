package com.AppDeck.client;

import org.eclipse.jetty.util.ajax.JSON;
import org.eclipse.jetty.util.ajax.JSONPojoConvertor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JSONReader {
    public static Map<String, Map<String, String>> getButtonsMap() {
        try {
            // Read the JSON file as a string
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/config.json")));

            // Register the Button class for JSON conversion
            JSON json = new JSON();
            json.addConvertor(Button.class, new JSONPojoConvertor(Button.class, true));

            // Parse the JSON string into a Map
            @SuppressWarnings("unchecked")
            Map<String, Object> parsedJson = (Map<String, Object>) JSON.parse(jsonContent);

            // Extract the "buttons" map from the parsed JSON
            @SuppressWarnings("unchecked")
            Map<String, Map<String, String>> buttonsMap = (Map<String, Map<String, String>>) parsedJson.get("buttons");

            return buttonsMap;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}