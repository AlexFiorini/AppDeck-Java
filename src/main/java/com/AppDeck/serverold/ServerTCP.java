package com.AppDeck.serverold;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerTCP extends Thread {

    private final ServerSocket server;

    public ServerTCP(int port) throws IOException {
        server = new ServerSocket(port);
        server.setSoTimeout(1000);
    }

    @Override
    public void run() {
        Socket connection = null;
        while (!Thread.interrupted()) {
            try {
                // attesa richiesta connessione da parte del client (attesa massima 1s)
                connection = server.accept();
                System.out.println("Messaggio richiesto da: "
                        + connection.getInetAddress().toString()
                        + ":" + connection.getPort());

                // creazione risposta
                try (
                     OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8)) {
                    String messaggio = "Ciao";
                    // invio al client della stringa che rappresenta la data/ora corrente
                    // con terminatori di riga
                    out.write(messaggio + "\r\n");
                    out.flush();
                    // chiusura stream di output e socket di connessione
                } catch (IOException ex) {
                    Logger.getLogger(ServerTCP.class.getName()).log(Level.SEVERE, null, ex);
                }
                connection.shutdownOutput();
                connection.close();
            } catch (IOException ignored) {
            } finally {
                if (connection != null) {
                    try {
                        connection.shutdownOutput();
                        connection.close();
                    } catch (IOException ignored) {}
                }
            }
        }

        // chiusura socket di ascolto del server
        try {
            server.close();
        } catch (IOException ignored) {}
    }
}