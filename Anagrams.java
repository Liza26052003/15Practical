import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// googlle AI mode was used for cunsaltation with VS code Agent
public class Anagrams{

public static void main(String[] args){
readLargeFile("/workspaces/15Practical/ulysses.text");
}

public static void readLargeFile(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); // Process each line here
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void findAnagrams(String filePath) throws IOException {
        // The Dictionary: Key = sorted letters, Value = list of matching words
        Map<String, List<String>> anagramMap = new HashMap<>();

        // 1. Read all lines from the file
        List<String> lines = Files.readAllLines(Path.of(filePath));

        for (String line : lines) {
            // Split by whitespace and strip non-alphabetic characters
            String[] words = line.split("\\s+");
            for (String w : words) {
                String cleanWord = w.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (cleanWord.isEmpty()) continue;

                // 2. Create the "Signature" (Key) by sorting letters
                char[] chars = cleanWord.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                // 3. Add to the map (using the anagram as the key)
                anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(cleanWord);
            }
        }

        // 4. Output results to the terminal
        anagramMap.forEach((key, list) -> {
            if (list.size() > 1) { // Only print if actual anagrams exist
                System.out.println("Key [" + key + "]: " + list);
            }
        });
    }








}