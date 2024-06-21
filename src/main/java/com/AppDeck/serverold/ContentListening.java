package com.AppDeck.serverold;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.browser.callback.InjectJsCallback;
import com.teamdev.jxbrowser.browser.callback.InjectJsCallback.Response;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.frame.Frame;
import com.teamdev.jxbrowser.js.JsAccessible;
import com.teamdev.jxbrowser.js.JsObject;
import com.teamdev.jxbrowser.navigation.event.FrameLoadFinished;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * This example demonstrates how to listen to DOM changes from a Java object.
 */
public final class ContentListening {

    public static void main(String[] args) {
        if (!License.addLicense()) {
            return;
        }
        Engine engine = Engine.newInstance(
                EngineOptions.newBuilder(HARDWARE_ACCELERATED).build());
        Browser browser = engine.newBrowser();
        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            JFrame frame = new JFrame("Content Listening");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        browser.set(InjectJsCallback.class, params -> {
            Frame frame = params.frame();
            String window = "window";
            JsObject jsObject = frame.executeJavaScript(window);
            if (jsObject == null) {
                throw new IllegalStateException(
                        format("'%s' JS object not found", window));
            }
            jsObject.putProperty("java", new JavaObject());
            return Response.proceed();
        });

        browser.navigation().on(FrameLoadFinished.class, event -> {
            String javaScript = load("https://alexfiorini.altervista.org/Java/observer.js");
            event.frame().executeJavaScript(javaScript);
        });

        String html = load("https://alexfiorini.altervista.org/Java/index.html");
        String base64Html = Base64.getEncoder().encodeToString(html.getBytes(UTF_8));
        String dataUrl = "data:text/html;base64," + base64Html;
        browser.navigation().loadUrl(dataUrl);
    }

    /**
     * Loads a resource content as a string.
     */
    private static String load(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            StringBuilder content = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
            }
            connection.disconnect();
            return content.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load resource from URL " + urlString, e);
        }
    }

    /**
     * The object observing DOM changes.
     *
     * <p>The class and methods that are invoked from JavaScript code must be public.
     */
    public static class JavaObject {

        @SuppressWarnings("unused") // invoked by callback processing code.
        @JsAccessible
        public void onButtonClick(String buttonId) {
            System.out.println("Bottone " + buttonId);
        }
    }
}
