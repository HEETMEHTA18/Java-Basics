/*
 * Problem Definition:
 * Develop a word counter that counts word frequency in a paragraph
 * using HashMap, maintains order using LinkedHashMap,
 * and sorts by key using TreeMap.
 * CO6
 */

import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String input = sc.nextLine().toLowerCase();

        String[] words = input.split("\\W+");

        // Count frequency using HashMap
        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty())
                freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // Maintain insertion order using LinkedHashMap
        LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>(freq);

        // Sort by key using TreeMap
        TreeMap<String, Integer> sortedMap = new TreeMap<>(freq);

        System.out.println("\nWord Frequency (HashMap): " + freq);
        System.out.println("Insertion Order (LinkedHashMap): " + linkedMap);
        System.out.println("Sorted by Key (TreeMap): " + sortedMap);
    }
}
