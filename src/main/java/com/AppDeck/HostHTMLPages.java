package com.AppDeck;

import com.AppDeck.client.NoLogging;
import com.AppDeck.client.WebSocketHandler;
import spark.Spark;

import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HostHTMLPages {
    public static void startHosting() {
        org.eclipse.jetty.util.log.Log.setLog(new NoLogging());

        String IP = "";
        int port = 32424;

        try {
            IP = IPFinder.FindIP();
        } catch(SocketException e) {
            e.getMessage();
        }

        if(IP.isEmpty()) {
            return;
        }

        CreateQR.createQR("http://"+IP+":"+port);
        Spark.ipAddress(IP);
        Spark.port(port);
        Spark.staticFiles.location("/src/main/resources");
        Spark.webSocket("/websocket", WebSocketHandler.class);

        Spark.init();

        Spark.get("/", (req, res) -> {
            try {
                return FileReader.readHTMLFile("src/main/resources/client/index.html");
            } catch (Exception e) {
                e.printStackTrace();
                return "Error reading HTML file";
            }
        });

        Spark.get("/dashboard.html", (req, res) -> {
            try {
                return FileReader.readHTMLFile("src/main/resources/server/index.html");
            } catch (Exception e) {
                e.printStackTrace();
                return "Error reading HTML file";
            }
        });

        Spark.get("/config.json", (req, res) -> {
            try {
                String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/resources/config.json")));
                res.type("application/json");
                return jsonContent;
            } catch (Exception e) {
                e.printStackTrace();
                return "Error reading JSON file";
            }
        });

        Spark.get("/QRCode.png", (req, res) -> {
            try {
                Path imagePath = Paths.get("src/main/resources/QRCode.png");
                byte[] imageBytes = Files.readAllBytes(imagePath);
                res.type("image/png");

                // Return the image bytes
                return imageBytes;
            } catch (Exception e) {
                e.printStackTrace();
                res.status(500);
                return "Error reading the image file";
            }
        });
    }
}
