import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class Q5 {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split into words
        String[] words = feedback.split("\\s+");

        // Stop words
        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            // Check whether word is a stop word
            boolean isStopWord = false;

            for (int j = 0; j < stopWords.length; j++) {

                if (word.equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (isStopWord) {
                continue;
            }

            // Count word
            if (frequency.containsKey(word)) {

                frequency.put(
                    word,
                    frequency.get(word) + 1
                );

            } else {

                frequency.put(word, 1);
            }
        }

        // Convert map entries into an ArrayList
        ArrayList<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        // Sort by frequency in descending order
        entries.sort(
            (entry1, entry2) ->
                entry2.getValue() - entry1.getValue()
        );

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback paragraph: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}