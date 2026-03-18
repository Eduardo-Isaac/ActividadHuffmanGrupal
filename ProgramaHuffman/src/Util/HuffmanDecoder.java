package Util;

import Model.Nodo;

public class HuffmanDecoder {

    public String decodificar(String bits, Nodo raiz) {
        StringBuilder resultado = new StringBuilder();
        Nodo actual = raiz;

        for (int i = 0; i < bits.length(); i++) {

            if (bits.charAt(i) == '0') {
                actual = actual.getIzquierda();
            } else {
                actual = actual.getDerecha();
            }

            // si es hoja
            if (actual.getIzquierda() == null && actual.getDerecha() == null) {
                resultado.append(actual.getCaracter());
                actual = raiz;
            }
        }

        return resultado.toString();
    }
}