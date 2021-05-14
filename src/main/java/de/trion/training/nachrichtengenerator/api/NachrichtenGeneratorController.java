package de.trion.training.nachrichtengenerator.api;

import de.trion.training.nachrichtengenerator.service.NachrichtenGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NachrichtenGeneratorController {
    private final NachrichtenGeneratorService nachrichtenGeneratorService;

    @Autowired
    public NachrichtenGeneratorController(NachrichtenGeneratorService nachrichtenGeneratorService) {
        this.nachrichtenGeneratorService = nachrichtenGeneratorService;
    }

    @GetMapping(
        value = "/nachricht",
        produces = "text/plain"
    )
    public String nachricht() {
        return nachrichtenGeneratorService.generate();
    }

    @GetMapping(
        value = "/version",
        produces = "text/plain"
    )
    public String version() {
        return "1.0";
    }
}
