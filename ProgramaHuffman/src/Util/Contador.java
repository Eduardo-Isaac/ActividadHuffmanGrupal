package Util;
import java.util.HashMap;
import java.util.Map;


public class Contador {

    public Map<Character, Integer> contar(String texto) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : texto.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        return charCount;
    }
}