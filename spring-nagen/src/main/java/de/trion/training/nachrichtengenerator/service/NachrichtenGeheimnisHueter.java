package de.trion.training.nachrichtengenerator.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NachrichtenGeheimnisHueter {
    static final String NAGEN_SECRET_FILE = "/secrets/secret";

    public String execute() {
        String secret;

        try {
            secret = new String(Files.readAllBytes(Paths.get(NAGEN_SECRET_FILE)));
        }
        catch (IOException e) {
            secret = "Leider ist kein Geheimnis konfiguriert.";
        }

        return secret;
    }
}
