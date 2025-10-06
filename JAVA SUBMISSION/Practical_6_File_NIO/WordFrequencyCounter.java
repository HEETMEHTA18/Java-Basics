import java.io.*;
import java.util.*;

class WordCount implements Comparable<WordCount> {
    String word;
    int count;
    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }
    
    @Override
    public int compareTo(WordCount other) {
        return Integer.compare(other.count, this.count);
    }
    
    @Override
    public String toString() {
        return String.format("%-20s : %d", word, count);
    }
}

public class WordFrequencyCounter {
    
    public static void createSampleTextFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Java is a popular programming language. ");
            writer.write("Java is used for developing web applications. ");
            writer.write("Object-oriented programming is a key feature of Java. ");
            writer.write("Java provides robust security features. ");
            writer.write("Many developers prefer Java for enterprise applications. ");
            writer.write("Java programming requires understanding of OOP concepts. ");
            writer.write("The Java Virtual Machine enables platform independence. ");
            writer.write("Java is widely used in Android app development. ");
            writer.write("Learning Java programming is essential for software development. ");
            writer.write("Java offers extensive libraries and frameworks for development. ");
            writer.write("Multithreading in Java enables concurrent programming. ");
            writer.write("Exception handling in Java makes applications more robust. ");
            writer.write("Java collections framework simplifies data structure usage. ");
            writer.write("File operations in Java are straightforward and efficient. ");
            writer.write("Java continues to evolve with new features and improvements.");
            
            System.out.println("Sample text file created: " + filename);
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }
    }
    
    public static Map<String, Integer> countWordFrequency(String filename) {
        Map<String, Integer> wordMap = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase()
                                    .replaceAll("[^a-zA-Z\\s]", "")
                                    .split("\\s+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
            System.out.println("\nTotal unique words: " + wordMap.size());
            
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return wordMap;
    }
    
    public static List<WordCount> getTopWords(Map<String, Integer> wordMap, int topN) {
        List<WordCount> wordList = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            wordList.add(new WordCount(entry.getKey(), entry.getValue()));
        }
        
        Collections.sort(wordList);
        
        return wordList.subList(0, Math.min(topN, wordList.size()));
    }
    
    public static void displayTopWords(List<WordCount> topWords) {
        System.out.println("\n=== Top 10 Most Frequent Words ===");
        System.out.println("Rank | Word                 | Frequency");
        System.out.println("-------------------------------------------");
        
        for (int i = 0; i < topWords.size(); i++) {
            System.out.printf("%-4d | %s\n", (i + 1), topWords.get(i));
        }
    }
    
    public static void saveResultsToFile(List<WordCount> topWords, String outputFile) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("WORD FREQUENCY ANALYSIS\n");
            writer.write("Generated on: " + new Date() + "\n");
            writer.write("=====================================\n\n");
            writer.write("Top 10 Most Frequent Words:\n");
            writer.write("Rank | Word                 | Frequency\n");
            writer.write("-------------------------------------------\n");
            
            for (int i = 0; i < topWords.size(); i++) {
                writer.write(String.format("%-4d | %s\n", (i + 1), topWords.get(i)));
            }
            
            System.out.println("\n Results saved to: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Word Frequency Counter ===\n");
        
        String inputFile = "sample_text.txt";
        String outputFile = "word_frequency_results.txt";
        
        createSampleTextFile(inputFile);
        
        System.out.println("\nAnalyzing word frequency...");
        Map<String, Integer> wordFrequency = countWordFrequency(inputFile);
        
        if (!wordFrequency.isEmpty()) {
            List<WordCount> topWords = getTopWords(wordFrequency, 10);
            displayTopWords(topWords);
            saveResultsToFile(topWords, outputFile);
        }
        
        System.out.println("\n=== Analysis completed ===");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
