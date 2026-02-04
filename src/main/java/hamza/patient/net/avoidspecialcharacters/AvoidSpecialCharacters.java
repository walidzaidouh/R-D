package hamza.patient.net.avoidspecialcharacters;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvoidSpecialCharacters {

    private static final Logger log = LoggerFactory.getLogger(AvoidSpecialCharacters.class);

    public static void main(String[] args) {
        SpringApplication.run(AvoidSpecialCharacters.class, args);
    }

    @Autowired
    TextCleaner cleaner;

    @PostConstruct
    public void test() {

        String[] samples = {

                // ===== Cas OCR / caractères corrompus =====
                "WALID□ZAIDOUH■■CLIENT�ABC",
                "WALID□ZAIDOUH",
                "FATIMA�ZAHRA",
                "AHMED□BEN■ALI",
                "FçATIMA�ZAHRA",
                "F'ATIMA�ZAHRA",
                "F''''ATIMA�ZAHRA",
                "F=)====!!!!!!ATIMA�ZAHRA",
                "FATIMA�ZAHRA",
                "YOUSEF�EL□AMRANI",
                "ROYAUME DU MAROC□□",
                "CARTE NATIONALE■■",

                // ===== Cas caractères spéciaux =====
                "WALID@@@@ZAIDOUH",
                "MOHAMED###ALI",
                "FATIMA##ZAHRA",
                "AHMED\\BENALI",
                "SARA__EL AMRANI",
                "KHALID<>OUAZZANI",
                "JEAN/PAUL:DURAND",

                // ===== Emojis & symboles =====
                "WALID🙂ZAIDOUH",
                "FATIMA💔ZAHRA",
                "AHMED🚀BENALI",
                "SARA❤️EL AMRANI",
                "YASSINE🔥OUAZZANI",

                // ===== Accents & Unicode =====
                "Ahméd Boutour",
                "ÉRIC DUPONT",
                "FRANÇOIS LÉVÊQUE",
                "NOËL ROBERT",
                "CHLOÉ DURAND",

                // ===== Noms composés =====
                "JEAN--PAUL@@DURAND",
                "MOHAMED##AMINE##EL FASSI",
                "ABD-EL□KARIM",
                "FATIMA--ZAHRA",
                "AHMED BEN—SALAH",

                // ===== Cas très sales (stress test) =====
                "@@@WALID###ZAIDOUH@@@",
                "##MOHAMED■■■ALI##",
                "FATIMA\u0000ZAHRA",
                "AHMED\t\nBENALI",
                "  SARA   ###   EL   AMRANI   ",
                "''''''''''''''''''''",
                "12345@@@@@",
                ""
        };

        for (String sample : samples) {
            log.info("Input  : {}", sample);
            log.info("Nettoyé: {}", cleaner.cleanIsoName(sample));
            log.info("----------------------------------");
        }

    }

}