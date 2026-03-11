import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// googlle AI mode was used for cunsaltation
public class Anagrams{

public static void main(String[] args){
readLargeFile("/workspaces/15Practical/ulysses.text");
}

public void readLargeFile(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); // Process each line here
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
















}