package Model;

import java.util.HashMap;
import java.util.Map;

public class ArbolHuffman {

    public Nodo construir(String texto) {
        Map<Character, Integer> frecuencia = new HashMap<>();

        for (char c : texto.toCharArray()) {
            frecuencia.put(c, frecuencia.getOrDefault(c, 0) + 1);
        }

        HeapMin heap = new HeapMin();

        for (Map.Entry<Character, Integer> entry : frecuencia.entrySet()) {
            heap.insertar(new Nodo(entry.getKey(), entry.getValue()));
        }

        while (heap.size() > 1) {
            Nodo izq = heap.extraerMin();
            Nodo der = heap.extraerMin();

            Nodo padre = new Nodo(
                    izq.getFrecuencia() + der.getFrecuencia(),
                    izq,
                    der
            );

            heap.insertar(padre);
        }

        return heap.extraerMin();
    }

    public Map<Character, String> generarCodigos(Nodo raiz) {
        Map<Character, String> codigos = new HashMap<>();
        generar(raiz, "", codigos);
        return codigos;
    }

    private void generar(Nodo nodo, String codigo, Map<Character, String> mapa) {
        if (nodo == null) return;

        if (nodo.esHoja()) {
            mapa.put(nodo.getCaracter(), codigo);
        }

        generar(nodo.getIzquierda(), codigo + "0", mapa);
        generar(nodo.getDerecha(), codigo + "1", mapa);
    }
}