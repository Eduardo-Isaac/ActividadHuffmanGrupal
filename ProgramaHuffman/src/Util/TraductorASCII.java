package Util;
import java.util.Map;

public class TraductorASCII {

    public String codificar(String texto, Map<Character, String> codigos) {
        StringBuilder resultado = new StringBuilder();

        for (char c : texto.toCharArray()) {
            String codigo = codigos.get(c);

            if (codigo != null) {
                resultado.append(codigo);
            } else {
                // por si un carácter no tiene código
                System.out.println("Advertencia: no hay código para '" + c + "'");
            }
        }

        return resultado.toString();
    }
}