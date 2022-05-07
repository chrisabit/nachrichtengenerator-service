package de.trion.training.nachrichtengenerator.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
class NachrichtenGenerator {
    static final String NAGEN_MESSAGE_FILE = "/config/message";

    String execute() {
        String nachricht;

        try {
            nachricht = new String(Files.readAllBytes(Paths.get(NAGEN_MESSAGE_FILE)));
        }
        catch (IOException e) {
            nachricht = "Leider ist keine Nachricht konfiguriert.";
        }

        new NachrichtenZaehler().incCount();

        return nachricht;
    }
}