import org.w3c.dom.Node; 

public class HuffmanDecoder {
    public static String decode(String bits, Node root) {
    StringBuilder result = new StringBuilder();
    Node current = root;

    for (int i = 0; i < bits.length(); i++) {
        if (i % 8 == 0) {
            System.out.println("Bloque: " + bits.substring(i, Math.min(i + 8, bits.length())));
        }

        if (bits.charAt(i) == '0') {
            current = current.left;
        } else {
            current = current.right;
        }

        if (current.left == null && current.right == null) {
            result.append(current.character);
            current = root;
        }
    }

    return result.toString();
}
}
