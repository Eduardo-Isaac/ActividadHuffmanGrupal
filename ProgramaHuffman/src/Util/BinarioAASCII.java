package Util;

public class BinarioAASCII {

    // Convierte string binario a texto ASCII
    public String binarioAAscii(String binario) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < binario.length(); i += 8) {
            String byteStr;

            if (i + 8 <= binario.length()) {
                byteStr = binario.substring(i, i + 8);
            } else {
                // relleno si no completa 8 bits
                byteStr = String.format("%-8s", binario.substring(i)).replace(' ', '0');
            }

            int ascii = Integer.parseInt(byteStr, 2);
            resultado.append((char) ascii);
        }

        return resultado.toString();
    }
}