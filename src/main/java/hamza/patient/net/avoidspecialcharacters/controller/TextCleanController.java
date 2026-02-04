package hamza.patient.net.avoidspecialcharacters.controller;

import hamza.patient.net.avoidspecialcharacters.service.TextCleaningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/text", produces = MediaType.APPLICATION_JSON_VALUE)
public class TextCleanController {

    private final TextCleaningService textCleaningService;

    public TextCleanController(TextCleaningService textCleaningService) {
        this.textCleaningService = textCleaningService;
    }


    @PostMapping(path = "/clean", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<String> clean(@RequestBody List<String> texts) {
        if (texts == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Corps JSON requis (liste de chaînes)");
        }
        return textCleaningService.cleanAll(texts);
    }
}
