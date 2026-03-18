import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Contador {
    public static void main(String[] args) {
        String filePath = "GREEN EGGS AND HAM.txt";
        Map<Character, Integer> charCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                }

                //newline
                charCount.put('\n', charCount.getOrDefault('\n', 0) + 1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}