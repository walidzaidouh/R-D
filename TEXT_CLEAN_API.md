# Text Clean API (Spring Boot)

## Endpoint
- **POST** `/api/text/clean`
- Request body: JSON array of strings (UTF-8).
- Response: JSON array of cleaned strings, same order as input.

## Règles de nettoyage
- Conserve uniquement les lettres Unicode (accents inclus) grâce à la regex `(?U)[^\\p{L}]+`.
- Toute séquence de caractères non autorisés est remplacée par un espace unique.
- Espaces multiples trimés, ainsi que début/fin de chaîne.
- Implémentation : `TextCleaner` compile le `Pattern` une seule fois (voir `src/main/java/hamza/patient/net/avoidspecialcharacters/TextCleaner.java`).

## Tester rapidement
```bash
./mvnw spring-boot:run
curl -X POST http://localhost:8080/api/text/clean \
  -H "Content-Type: application/json" \
  -d '["Crème-brûlée!!! 100% délicieuse 😋","🔥L\"été 2024 — succès à 100%!!! #Paris🇫🇷"]'
```

## Jeu de cas fourni
- Fichier JSON prêt à l’emploi : `src/test/resources/text-clean-cases.json`
- Contient 12 cas (accents, emails/URL, emojis, chiffres, bruit OCR, multilanguage, etc.).

## UI Swagger
- Accessible après démarrage sur `http://localhost:8080/swagger-ui.html` (fourni par springdoc).
- Dans l’onglet `POST /api/text/clean`, collez la liste issue du fichier JSON pour vérifier les résultats.
