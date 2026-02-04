package hamza.patient.net.avoidspecialcharacters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class TextCleaner {

    private final Pattern pattern;
    private final boolean trimMultiSpaces;

    public TextCleaner(@Value("${text.clean.regex}") String regex,
                       @Value("${text.clean.trim.multispaces:false}") boolean trimMultiSpaces) {
        this.pattern = Pattern.compile(regex);
        System.out.println("regex : " + this.pattern);
        this.trimMultiSpaces = trimMultiSpaces;
    }

    public String clean(String input) {
        if (input == null) {
            return null;
        }

        String result = pattern.matcher(input).replaceAll(" ");
        if (trimMultiSpaces) {
            result = result.replaceAll(" +", " ").trim();
        }
        return result;
    }
}