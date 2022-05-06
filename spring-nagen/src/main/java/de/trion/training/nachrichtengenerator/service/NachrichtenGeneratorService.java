package de.trion.training.nachrichtengenerator.service;

import org.springframework.stereotype.Service;

@Service
public class NachrichtenGeneratorService {
    private final NachrichtenGenerator nachrichtenGenerator;

    public NachrichtenGeneratorService(NachrichtenGenerator nachrichtenGenerator) {
        this.nachrichtenGenerator = nachrichtenGenerator;
    }

    public String generate() {
        return nachrichtenGenerator.execute();
    }
}
