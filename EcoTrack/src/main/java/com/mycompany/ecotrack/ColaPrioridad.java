
package Grupo_08.estructuras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 *
 * @author Grupo 8
 */
public class ColaPrioridad<E> {
    private ArrayList<E> heap;
    private Comparator<E> comparador;

    public ColaPrioridad(Comparator<E> comparador) {
        this.heap = new ArrayList<>();
        this.comparador = comparador;
    }


    public void encolar(E elemento) {
        heap.add(elemento);
        flotar(heap.size() - 1);
    }


    public E desencolar() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola de prioridad está vacía.");
        }

        intercambiar(0, heap.size() - 1);
        E elementoPrioritario = heap.remove(heap.size() - 1);
        hundir(0); 
        
        return elementoPrioritario;
    }

    public E peek() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola de prioridad está vacía.");
        }
        return heap.get(0);
    }
    
    public boolean estaVacia() {
        return heap.isEmpty();
    }

    private void flotar(int indice) {
        while (indice > 0 && esMayor(indice, padre(indice))) {
            intercambiar(indice, padre(indice));
            indice = padre(indice);
        }
    }


    private void hundir(int indice) {
        int indiceMayor = indice;
        int hijoIzquierdo = hijoIzquierdo(indice);
        int hijoDerecho = hijoDerecho(indice);


        if (hijoIzquierdo < heap.size() && esMayor(hijoIzquierdo, indiceMayor)) {
            indiceMayor = hijoIzquierdo;
        }

        if (hijoDerecho < heap.size() && esMayor(hijoDerecho, indiceMayor)) {
            indiceMayor = hijoDerecho;
        }

        if (indiceMayor != indice) {
            intercambiar(indice, indiceMayor);
            hundir(indiceMayor);
        }
    }


    private boolean esMayor(int indice1, int indice2) {
        return comparador.compare(heap.get(indice1), heap.get(indice2)) > 0;
    }

    private void intercambiar(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }


    private int padre(int indice) {
        return (indice - 1) / 2;
    }

    private int hijoIzquierdo(int indice) {
        return 2 * indice + 1;
    }

    private int hijoDerecho(int indice) {
        return 2 * indice + 2;
    }
}
