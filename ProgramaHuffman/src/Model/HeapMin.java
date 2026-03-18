package Model;
import java.util.ArrayList;

public class HeapMin {
    private ArrayList<Nodo> heap = new ArrayList<>();

    public void insertar(Nodo nodo) {
        heap.add(nodo);
        subir(heap.size() - 1);
    }

    public Nodo extraerMin() {
        if (heap.isEmpty()) return null;

        Nodo raiz = heap.get(0);
        Nodo ultimo = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            bajar(0);
        }

        return raiz;
    }

    public int size() {
        return heap.size();
    }

    private void subir(int i) {
        int padre = (i - 1) / 2;

        if (i > 0 && heap.get(i).frecuencia < heap.get(padre).frecuencia) {
            intercambiar(i, padre);
            subir(padre);
        }
    }

    private void bajar(int i) {
        int izq = 2 * i + 1;
        int der = 2 * i + 2;
        int menor = i;

        if (izq < heap.size() &&
                heap.get(izq).frecuencia < heap.get(menor).frecuencia) {
            menor = izq;
        }

        if (der < heap.size() &&
                heap.get(der).frecuencia < heap.get(menor).frecuencia) {
            menor = der;
        }

        if (menor != i) {
            intercambiar(i, menor);
            bajar(menor);
        }
    }

    private void intercambiar(int i, int j) {
        Nodo temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
