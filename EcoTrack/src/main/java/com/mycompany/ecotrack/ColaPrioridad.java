package com.mycompany.ecotrack;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Cola de prioridad (max-heap) implementada con arreglo dinamico propio.
 */
public class ColaPrioridad<E> implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ArrayList<E> heap;

    private transient Comparator<E> comparador;

    public ColaPrioridad(Comparator<E> comparador) {
        this.heap = new ArrayList<>();
        this.comparador = comparador;
    }

    /**
     * Se usa tras deserializar (persistencia) para reinyectar el comparador.
     */
    public void setComparador(Comparator<E> comparador) {
        this.comparador = comparador;
    }

    public void agregarVehiculo(E elemento) {
        if (comparador == null) {
            throw new IllegalStateException("Comparador no inicializado.");
        }
        heap.addLast(elemento);
        flotar(heap.size() - 1);
    }

    public E despacharVehiculo() {
        if (estaVacia()) {
            throw new NoSuchElementException("No hay elementos para despachar.");
        }

        intercambiar(0, heap.size() - 1);
        E elementoPrioritario = heap.removeLast();

        if (!estaVacia()) {
            hundir(0);
        }

        return elementoPrioritario;
    }

    public E verSiguienteVehiculo() {
        if (estaVacia()) {
            throw new NoSuchElementException("No existen mas elementos.");
        }
        return heap.get(0);
    }

    public boolean estaVacia() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void flotar(int indice) {
        while (indice > 0 && esMayor(indice, padre(indice))) {
            intercambiar(indice, padre(indice));
            indice = padre(indice);
        }
    }

    private void hundir(int indice) {
        int indiceMayor = indice;
        int izq = hijoIzquierdo(indice);
        int der = hijoDerecho(indice);

        if (izq < heap.size() && esMayor(izq, indiceMayor)) {
            indiceMayor = izq;
        }

        if (der < heap.size() && esMayor(der, indiceMayor)) {
            indiceMayor = der;
        }

        if (indiceMayor != indice) {
            intercambiar(indice, indiceMayor);
            hundir(indiceMayor);
        }
    }

    private boolean esMayor(int i, int j) {
        return comparador.compare(heap.get(i), heap.get(j)) > 0;
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
