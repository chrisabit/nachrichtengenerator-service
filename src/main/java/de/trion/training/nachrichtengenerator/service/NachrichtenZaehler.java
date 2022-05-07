package de.trion.training.nachrichtengenerator.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NachrichtenZaehler {
    // Das sollte man besser mit einer transaktionsgeschuetzen Datenbank machen ;-)
    private static final String DEFAULT_NAGEN_COUNT_FILE = "/tmp/count";
    private static final String ENV_NAGEN_COUNT_FILE = "NAGEN_COUNT_FILE";

    private final Path countFilePath;

    public NachrichtenZaehler() {
        String envFile = System.getenv(ENV_NAGEN_COUNT_FILE);

        countFilePath = envFile != null ? Paths.get(envFile) : Paths.get(DEFAULT_NAGEN_COUNT_FILE);
    }

    public int getCount() {
        int count;

        try {
            count = Integer.parseInt(new String(Files.readAllBytes(countFilePath)));
        }
        catch (Exception e) {
            count = 0;
        }

        return count;
    }

    void incCount() {
        int count = getCount();
        count++;

        try {
            if (Files.notExists(countFilePath.getParent())) {
                Files.createDirectory(countFilePath.getParent());
            }
            Files.write(countFilePath, Integer.toString(count).getBytes());
        }
        catch (IOException e) {
            // Hier sollte richtig gelogged werden ;-)
            e.printStackTrace();
        }
    }
}
