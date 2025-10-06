import java.io.*;
import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String fileName = "sample_text.txt";
        Map<String, Integer> wordCount = new HashMap<>();

        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNext()) {
                String word = sc.next().toLowerCase().replaceAll("[^a-z]", "");
                if (!word.isEmpty())
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Top 10 Most Frequent Words:");
        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}
