package hamza.patient.net.avoidspecialcharacters.service;

import hamza.patient.net.avoidspecialcharacters.TextCleaner;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TextCleaningService {

    private final TextCleaner cleaner;

    public TextCleaningService(TextCleaner cleaner) {
        this.cleaner = cleaner;
    }

    public List<String> cleanAll(List<String> inputs) {
        if (inputs == null) {
            return Collections.emptyList();
        }
        return inputs.stream()
                .map(text -> Objects.nonNull(text) ? cleaner.clean(text) : null)
                .collect(Collectors.toList());
    }
}
