import java.io.*;
import java.nio.file.*;
import java.util.*;
 
public class Anagrams{

public static void main(String[] args) throws IOException {
 
findAnagrams("/workspaces/15Practical/ulysses.text");
}

public static void readLargeFile(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); 
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void findAnagrams(String filePath) throws IOException {
        
        Map<String, List<String>> anagramMap = new HashMap<>();
 
        List<String> lines = Files.readAllLines(Path.of(filePath));

        for (String line : lines) {
              
            String[] words = line.split("\\s+");
            for (String w : words) {
                String cleanWord = w.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (cleanWord.isEmpty()) continue;

             
                char[] chars = cleanWord.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
 
                anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(cleanWord);
            }
        }
        anagramMap.forEach((key, list) -> {
            if (list.size() > 1) {  
                System.out.println("Key [" + key + "]: " + list);
            }
        });
    }








}