package Util;

public class ASCIIABinario {

    public String asciiABinario(String texto) {
        StringBuilder binario = new StringBuilder();

        for (char c : texto.toCharArray()) {
            String bits = String.format("%8s", Integer.toBinaryString(c))
                    .replace(' ', '0');
            binario.append(bits);
        }

        return binario.toString();
    }
}