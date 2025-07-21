import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * A real-time message sanitization module for a chat application.
 * This class handles cleaning, formatting, moderation, and analysis of messages.
 */
public class MessageSanitizer {

    // Using a Set for efficient 'contains' checks and a Map for replacements.
    private static final Set<String> BANNED_WORDS;
    private static final Map<String, String> EMOJI_MAP;
    private static final Set<String> ABBREVIATIONS;

    // Static initializer block to populate the data stores.
    // In a production app, these could be loaded from a configuration file or database.
    static {
        BANNED_WORDS = new HashSet<>(Arrays.asList("damn", "hell", "crap", "darn"));

        EMOJI_MAP = new HashMap<>();
        EMOJI_MAP.put(":smile:", "😊");
        EMOJI_MAP.put(":heart:", "❤️");
        EMOJI_MAP.put(":lol:", "😂");
        EMOJI_MAP.put(":sad:", "😢");

        ABBREVIATIONS = new HashSet<>(Arrays.asList("brb", "idk", "omg", "lol", "btw", "ttyl"));
    }

    /**
     * A result object to hold the sanitized message and its analysis.
     */
    public static class SanitizationResult {
        private final String sanitizedMessage;
        private final String analysisSummary;

        public SanitizationResult(String sanitizedMessage, String analysisSummary) {
            this.sanitizedMessage = sanitizedMessage;
            this.analysisSummary = analysisSummary;
        }

        public String getSanitizedMessage() {
            return sanitizedMessage;
        }

        public String getAnalysisSummary() {
            return analysisSummary;
        }

        @Override
        public String toString() {
            return "✅ Sanitized: \"" + sanitizedMessage + "\"\n" + "🔍 " + analysisSummary;
        }
    }

    /**
     * The main method to process a raw message string.
     * It orchestrates the cleaning, moderation, enhancement, and analysis.
     *
     * @param rawMessage The raw input string from the user.
     * @return A SanitizationResult object containing the processed message and analysis.
     */
    public SanitizationResult processMessage(String rawMessage) {
        if (rawMessage == null || rawMessage.trim().isEmpty()) {
            return new SanitizationResult("", "No message content.");
        }

        // Apply sanitization steps in logical order.
        String message = cleanAndFormat(rawMessage);
        message = moderateContent(message);
        message = enhanceExpressiveness(message);

        // Analyze the final, sanitized message.
        String analysis = analyzeMessage(message);

        return new SanitizationResult(message, analysis);
    }

    /**
     * Cleans and formats the string by trimming whitespace and applying sentence case.
     */
    private String cleanAndFormat(String message) {
        // 1. String.trim(): Remove leading and trailing whitespace.
        String cleaned = message.trim();

        // 2. String.replaceAll(): Replace multiple spaces between words with a single space.
        cleaned = cleaned.replaceAll("\\s+", " ");

        // 3. Apply sentence capitalization.
        if (!cleaned.isEmpty()) {
            cleaned = cleaned.substring(0, 1).toUpperCase() + cleaned.substring(1).toLowerCase();
        }
        return cleaned;
    }

    /**
     * Moderates content by replacing banned words with '***'.
     */
    private String moderateContent(String message) {
        String moderated = message;
        for (String word : BANNED_WORDS) {
            // Use regex for case-insensitive `(?i)` and whole-word `\\b` matching.
            // Pattern.quote() escapes any special characters in the banned word itself.
            String regex = "(?i)\\b" + Pattern.quote(word) + "\\b";
            moderated = moderated.replaceAll(regex, "***");
        }
        return moderated;
    }

    /**
     * Enhances expressiveness by replacing text placeholders with actual emojis.
     */
    private String enhanceExpressiveness(String message) {
        String enhanced = message;
        for (Map.Entry<String, String> entry : EMOJI_MAP.entrySet()) {
            // String.replace is used for literal string replacement.
            // Since cleanAndFormat() lowercased the message, placeholders must be lowercase.
            enhanced = enhanced.replace(entry.getKey(), entry.getValue());
        }
        return enhanced;
    }

    /**
     * Analyzes the message to detect and count known abbreviations/slang.
     */
    private String analyzeMessage(String message) {
        Map<String, Long> counts = new HashMap<>();

        // Use Pattern and Matcher to find all occurrences of each abbreviation.
        for (String abbr : ABBREVIATIONS) {
            Pattern pattern = Pattern.compile("(?i)\\b" + Pattern.quote(abbr) + "\\b");
            Matcher matcher = pattern.matcher(message);
            long count = matcher.results().count(); // Java 9+ stream-based count
            if (count > 0) {
                counts.put(abbr.toUpperCase(), count);
            }
        }

        if (counts.isEmpty()) {
            return "Analysis: No known abbreviations found.";
        }

        // Build a summary string.
        String summaryDetails = counts.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", "));

        long total = counts.values().stream().mapToLong(Long::longValue).sum();

        return String.format("Analysis: Found %d abbreviation(s) -> %s", total, summaryDetails);
    }

    /**
     * Main method to demonstrate the module's functionality.
     */
    public static void main(String[] args) {
        MessageSanitizer sanitizer = new MessageSanitizer();
        String[] testMessages = {
                "   omg what the hell is this?   ",
                "brb, i need to go. btw this is awesome! :smile:",
                "I dOn't KNow, lol! this is crazy :heart: :heart:",
                "This is damn annoying.",
                "HELL no! CRAP! :sad:",
                "This is a clean message with no slang.",
                "LOL, idk what you mean. ttyl. :lol:"
        };

        System.out.println("--- Real-Time Message Sanitization Demo---");
        for (String msg : testMessages) {
            System.out.println("\nOriginal: \"" + msg + "\"");
            SanitizationResult result = sanitizer.processMessage(msg);
            System.out.println(result);
            System.out.println("-------------------------------------------");
        }
    }
}