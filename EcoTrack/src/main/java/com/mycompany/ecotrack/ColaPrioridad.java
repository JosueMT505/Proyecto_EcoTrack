/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.estructuras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class ColaPrioridad<E> {
    private ArrayList<E> heap;
    private Comparator<E> comparador;

    /**
     * Constructor. Requiere un Comparator para establecer la prioridad.
     * @param comparador El comparador que define el orden de prioridad.
     */
    public ColaPrioridad(Comparator<E> comparador) {
        this.heap = new ArrayList<>();
        this.comparador = comparador;
    }

    // --- Operaciones del Heap ---

    /**
     * Agrega un elemento a la cola de prioridad y mantiene la propiedad del Heap.
     * @param elemento El elemento a agregar.
     */
    public void encolar(E elemento) {
        heap.add(elemento);
        // Sube el elemento hasta su posición correcta (Up-Heap o swim)
        flotar(heap.size() - 1);
    }

    /**
     * Remueve y devuelve el elemento de más alta prioridad (la raíz del Heap).
     * @return El elemento de más alta prioridad.
     */
    public E desencolar() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola de prioridad está vacía.");
        }
        
        // 1. Intercambiar la raíz con el último elemento
        intercambiar(0, heap.size() - 1);
        
        // 2. Extraer el elemento (ahora en la última posición)
        E elementoPrioritario = heap.remove(heap.size() - 1);
        
        // 3. Restaurar la propiedad del Heap (Down-Heap o sink)
        hundir(0); 
        
        return elementoPrioritario;
    }

    /**
     * Devuelve el elemento de más alta prioridad sin removerlo.
     */
    public E peek() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola de prioridad está vacía.");
        }
        return heap.get(0);
    }
    
    public boolean estaVacia() {
        return heap.isEmpty();
    }
    
    // --- Lógica interna de Heap (Implementación Propia) ---

    // Mueve un elemento hacia arriba en el Heap
    private void flotar(int indice) {
        // Mientras no sea la raíz y el hijo tenga mayor prioridad que el padre
        while (indice > 0 && esMayor(indice, padre(indice))) {
            intercambiar(indice, padre(indice));
            indice = padre(indice);
        }
    }

    // Mueve un elemento hacia abajo en el Heap
    private void hundir(int indice) {
        int indiceMayor = indice;
        int hijoIzquierdo = hijoIzquierdo(indice);
        int hijoDerecho = hijoDerecho(indice);

        // Si el hijo izquierdo tiene mayor prioridad que el nodo actual
        if (hijoIzquierdo < heap.size() && esMayor(hijoIzquierdo, indiceMayor)) {
            indiceMayor = hijoIzquierdo;
        }

        // Si el hijo derecho tiene mayor prioridad que el nodo actual (o el hijo izquierdo)
        if (hijoDerecho < heap.size() && esMayor(hijoDerecho, indiceMayor)) {
            indiceMayor = hijoDerecho;
        }

        // Si el mayor no es el nodo actual, intercambiar y continuar hundiendo
        if (indiceMayor != indice) {
            intercambiar(indice, indiceMayor);
            hundir(indiceMayor);
        }
    }

    // Compara la prioridad: devuelve true si el elemento1 tiene MAYOR prioridad que elemento2
    private boolean esMayor(int indice1, int indice2) {
        // Usamos el comparador para determinar qué elemento tiene "más prioridad"
        // Si el comparador devuelve > 0, significa que el elemento1 es "mayor"
        return comparador.compare(heap.get(indice1), heap.get(indice2)) > 0;
    }

    private void intercambiar(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Fórmulas para calcular índices en un Heap basado en Array
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
