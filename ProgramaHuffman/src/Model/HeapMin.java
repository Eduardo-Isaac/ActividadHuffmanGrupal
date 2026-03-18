package Model;

import java.util.ArrayList;

public class HeapMin {
    private ArrayList<Integer> heap;

    public HeapMin() {
        heap = new ArrayList<>();
    }

    public void insertar(int valor) {
        heap.add(valor);
        heapifyUp(heap.size() - 1);
    }

    private void heapifyUp(int index) {
        int padre = (index - 1) / 2;

        while (index > 0 && heap.get(index) < heap.get(padre)) {
            intercambiar(index, padre);
            index = padre;
            padre = (index - 1) / 2;
        }
    }

    private void intercambiar(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void imprimir() {
        System.out.println(heap);
    }
}
