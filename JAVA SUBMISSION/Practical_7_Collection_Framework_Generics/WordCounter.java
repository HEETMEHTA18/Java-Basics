import java.util.*;

public class WordCounter {
    
    public static Map<String, Integer> countWordFrequency(String paragraph) {
        Map<String, Integer> wordCount = new HashMap<>();
        
        String[] words = paragraph.toLowerCase()
                                  .replaceAll("[^a-zA-Z\\s]", "")
                                  .split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        return wordCount;
    }
    
    public static void displayHashMap(Map<String, Integer> map) {
        System.out.println("\n=== HashMap (Unordered) ===");
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%-15s : %d  ", entry.getKey(), entry.getValue());
            count++;
            if (count % 3 == 0) System.out.println();
        }
        if (count % 3 != 0) System.out.println();
        System.out.println("Total: " + map.size() + " unique words");
    }
    
    public static void displayLinkedHashMap(String paragraph) {
        System.out.println("\n=== LinkedHashMap (Insertion Order) ===");
        
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        
        String[] words = paragraph.toLowerCase()
                                  .replaceAll("[^a-zA-Z\\s]", "")
                                  .split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        int count = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.printf("%-15s : %d  ", entry.getKey(), entry.getValue());
            count++;
            if (count % 3 == 0) System.out.println();
        }
        if (count % 3 != 0) System.out.println();
        System.out.println("Total: " + wordCount.size() + " unique words");
    }
    
    public static void displayTreeMap(Map<String, Integer> originalMap) {
        System.out.println("\n=== TreeMap (Sorted Alphabetically) ===");
        
        Map<String, Integer> sortedMap = new TreeMap<>(originalMap);
        
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.printf("%-15s : %d  ", entry.getKey(), entry.getValue());
            count++;
            if (count % 3 == 0) System.out.println();
        }
        if (count % 3 != 0) System.out.println();
        System.out.println("Total: " + sortedMap.size() + " unique words");
    }
    
    public static void displayTopWords(Map<String, Integer> wordCount) {
        System.out.println("\n=== Top 3 Most Frequent Words ===");
        
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
        Collections.sort(entries, (a, b) -> b.getValue().compareTo(a.getValue()));
        
        for (int i = 0; i < Math.min(3, entries.size()); i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            System.out.printf("%d. %-15s : %d times\n", (i + 1), entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Word Counter with Different Map Types ===\n");
        
        String paragraph = "Heet loves programming in Java. " +
                          "Rahul enjoys Java development. " +
                          "Priya prefers Java for projects. " +
                          "Java is popular among students.";
        
        System.out.println("Input Text:");
        System.out.println(paragraph);
        System.out.println("\n" + "=".repeat(50));
        
        Map<String, Integer> wordFrequency = countWordFrequency(paragraph);
        
        displayHashMap(wordFrequency);
        
        displayLinkedHashMap(paragraph);
        
        displayTreeMap(wordFrequency);
        
        displayTopWords(wordFrequency);
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("\nKey Differences:");
        System.out.println("HashMap      : Fast, unordered");
        System.out.println("LinkedHashMap: Maintains insertion order");
        System.out.println("TreeMap      : Sorted alphabetically");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
