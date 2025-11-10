/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.estructuras;

import java.util.Comparator;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class ListaEnlazadaCircular<E> implements Iterable<E>{
    private Nodo<E> cabeza;
    private int tamanio;

    public ListaEnlazadaCircular() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    // Método para agregar un elemento al final de la lista
    public void agregar(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (cabeza == null) {
            // Si la lista está vacía, el nuevo nodo es la cabeza y se apunta a sí mismo
            cabeza = nuevoNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            // El último nodo (anterior a la cabeza)
            Nodo<E> ultimo = cabeza.getAnterior();
            
            // 1. El nuevo nodo apunta hacia adelante a la cabeza
            nuevoNodo.setSiguiente(cabeza);
            // 2. El nuevo nodo apunta hacia atrás al anterior último
            nuevoNodo.setAnterior(ultimo);

            // 3. La cabeza ahora apunta hacia atrás al nuevo nodo
            cabeza.setAnterior(nuevoNodo);
            // 4. El anterior último ahora apunta hacia adelante al nuevo nodo
            ultimo.setSiguiente(nuevoNodo);
        }
        tamanio++;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return tamanio == 0;
    }

    // Método para obtener el tamaño
    public int getTamanio() {
        return tamanio;
    }

    // ********** Métodos Requeridos por el proyecto **********

    /**
     * Requisito: Implementar un iterador propio para recorrer la lista de residuos
     * (Requerimiento 5).
     * @return una instancia del iterador personalizado.
     */
    @Override
    public IteradorListaCircular<E> iterator() {
        return new IteradorListaCircular<>(cabeza);
    }

    // ********** Requisito: Ordenamiento y Comparación (Requerimiento 4) **********

    /**
     * Método para ordenar la lista in-place utilizando uno de los comparadores.
     * En este caso se ejemplifica usando una selección simple para fines de demostración.
     * En una implementación real de estructuras de datos, se podría usar un algoritmo más eficiente
     * adaptado a listas enlazadas.
     * @param comparador
     */
    public void ordenar(Comparator<E> comparador) {
        if (tamanio <= 1) return;

        // Implementación de Bubble Sort adaptado a Lista Enlazada Circular Doble
        for (int i = 0; i < tamanio - 1; i++) {
            Nodo<E> actual = cabeza;
            for (int j = 0; j < tamanio - 1 - i; j++) {
                
                // Si el nodo actual es "mayor" (según el comparador) que el siguiente, se intercambian
                if (comparador.compare(actual.getContenido(), actual.getSiguiente().getContenido()) > 0) {
                    
                    // Solo intercambiamos el contenido (más simple que re-linkear los nodos)
                    E temp = actual.getContenido();
                    actual.setContenido(actual.getSiguiente().getContenido());
                    actual.getSiguiente().setContenido(temp);
                }
                actual = actual.getSiguiente();
            }
        }
    }
}
