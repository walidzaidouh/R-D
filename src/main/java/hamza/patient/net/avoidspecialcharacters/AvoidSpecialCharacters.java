package hamza.patient.net.avoidspecialcharacters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AvoidSpecialCharacters {

    private static final Logger log = LoggerFactory.getLogger(AvoidSpecialCharacters.class);

    public static void main(String[] args) {
        SpringApplication.run(AvoidSpecialCharacters.class, args);
    }

    //@Bean
    CommandLineRunner demo(TextCleaner cleaner) {
        return args -> {
            String sample = "WALID□ZAIDOUH■■CLIENT�ABC";
            log.info("Input  : {}", sample);
            log.info("Nettoyé: {}", cleaner.clean(sample));

            String sample1 = "\"Contactez-moi: test.email+spam@gmail.com #urgent\"\n";
            log.info("Input  : {}", sample1);
            log.info("Nettoyé: {}", cleaner.clean(sample1));

            String sample2 = "Æsop’s é fables — œuvre naïve";
            log.info("Input  : {}", sample2);
            log.info("Nettoyé: {}", cleaner.clean(sample2));

        };
    }
}
