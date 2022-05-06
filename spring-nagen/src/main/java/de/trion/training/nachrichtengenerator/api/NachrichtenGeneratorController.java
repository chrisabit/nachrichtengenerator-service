package de.trion.training.nachrichtengenerator.api;

import de.trion.training.nachrichtengenerator.service.NachrichtenGeheimnisHueter;
import de.trion.training.nachrichtengenerator.service.NachrichtenGeneratorService;
import de.trion.training.nachrichtengenerator.service.NachrichtenZaehler;
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
        value = "/zugriffe",
        produces = "text/plain"
    )
    public String getZugriffe() {
        return Integer.toString(new NachrichtenZaehler().getCount());
    }

    @GetMapping(
        value = "/geheim",
        produces = "text/plain"
    )
    public String getGeheim() {
        return new NachrichtenGeheimnisHueter().execute();
    }

}
