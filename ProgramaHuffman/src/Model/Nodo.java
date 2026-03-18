package Model;

import java.util.ArrayList;

public class Nodo implements Comparable<Nodo> {
    char caracter;
    int frecuencia;
    Nodo izquierda, derecha;

    public Nodo(char caracter, int frecuencia) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
    }

    public Nodo(int frecuencia, Nodo izq, Nodo der) {
        this.frecuencia = frecuencia;
        this.izquierda = izq;
        this.derecha = der;
    }

    public boolean esHoja() {
        return izquierda == null && derecha == null;
    }

    @Override
    public int compareTo(Nodo o) {
        return this.frecuencia - o.frecuencia;
    }
}