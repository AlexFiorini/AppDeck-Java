package com.AppDeck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static String readHTMLFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static String readJSFile (String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
