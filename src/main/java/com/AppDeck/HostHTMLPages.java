package com.AppDeck;

import com.AppDeck.server.NoLogging;
import com.AppDeck.server.WebSocketHandler;
import spark.Spark;

import java.awt.*;
import java.io.*;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
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
        Spark.webSocketIdleTimeoutMillis(0);

        Spark.init();

        Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            URI oURL = new URI("http://"+IP+":"+port+"/dashboard.html");
            desktop.browse(oURL);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

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

        Spark.post("/save_config.php", (req, res) -> {
            try {
                // Get the POST data from the request body
                String postData = req.body();

                // Path to the PHP interpreter
                String phpInterpreter = "src/main/resources/php-8.1.29-Win32-vs16-x64/php.exe";
                // Path to the PHP script
                String phpScript = "src/main/resources/server/php/save_config.php";

                ProcessBuilder pb = new ProcessBuilder(phpInterpreter, phpScript);
                // Pass the POST data as a command line argument to the PHP script
                pb.command().add(postData);

                Process process = pb.start();

                // Capture output from PHP script
                InputStream inputStream = process.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder output = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    output.append(line).append("\n");
                }

                // Wait for the process to finish
                int exitCode = process.waitFor();

                // Check if PHP script executed successfully
                if (exitCode == 0) {
                    return output.toString();
                } else {
                    res.status(500);
                    return "PHP script execution failed";
                }
            } catch (Exception e) {
                e.printStackTrace();
                res.status(500);
                return "Error executing PHP script";
            }
        });

        Spark.get("/js/buttonConfig.js", (req, res) -> {
            try {
                return FileReader.readJSFile("src/main/resources/server/js/buttonConfig.js");
            } catch (Exception e) {
                e.printStackTrace();
                return "Error reading HTML file";
            }
        });

        Spark.get("/js/buttonEditOverlay.js", (req, res) -> {
            try {
                return FileReader.readJSFile("src/main/resources/server/js/buttonEditOverlay.js");
            } catch (Exception e) {
                e.printStackTrace();
                return "Error reading HTML file";
            }
        });

        Spark.get("/js/fullscreen.js", (req, res) -> {
            try {
                return FileReader.readJSFile("src/main/resources/server/js/fullscreen.js");
            } catch (Exception e) {
                e.printStackTrace();
                return "Error reading HTML file";
            }
        });

        Spark.get("/js/qrCodeOverlay.js", (req, res) -> {
            try {
                return FileReader.readJSFile("src/main/resources/server/js/qrCodeOverlay.js");
            } catch (Exception e) {
                e.printStackTrace();
                return "Error reading HTML file";
            }
        });

        Spark.get("/js/rightClickMenu.js", (req, res) -> {
            try {
                return FileReader.readJSFile("src/main/resources/server/js/rightClickMenu.js");
            } catch (Exception e) {
                e.printStackTrace();
                return "Error reading HTML file";
            }
        });

        Spark.get("/js/websocket.js", (req, res) -> {
            try {
                return FileReader.readJSFile("src/main/resources/server/js/websocket.js");
            } catch (Exception e) {
                e.printStackTrace();
                return "Error reading HTML file";
            }
        });
    }
}