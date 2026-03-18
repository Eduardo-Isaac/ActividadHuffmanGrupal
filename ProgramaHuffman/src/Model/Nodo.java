package Model;

public class Nodo implements Comparable<Nodo> {
    private char caracter;
    private int frecuencia;
    private Nodo izquierda;
    private Nodo derecha;

    public Nodo(char caracter, int frecuencia) {
        this.caracter = caracter;
        this.frecuencia = frecuencia;
    }

    public Nodo(int frecuencia, Nodo izquierda, Nodo derecha) {
        this.frecuencia = frecuencia;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    public boolean esHoja() {
        return izquierda == null && derecha == null;
    }

    // Getters
    public char getCaracter() {
        return caracter;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    @Override
    public int compareTo(Nodo o) {
        return this.frecuencia - o.frecuencia;
    }
}