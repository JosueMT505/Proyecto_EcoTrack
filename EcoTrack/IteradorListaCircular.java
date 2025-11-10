/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.estructuras;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class IteradorListaCircular<E> implements Iterator<E> {
    private Nodo<E> inicio; // Referencia al primer elemento de la iteración
    private Nodo<E> actual;
    private boolean inicioRecorrido = false;

    public IteradorListaCircular(Nodo<E> cabeza) {
        this.inicio = cabeza;
        this.actual = cabeza;
    }

    /**
     * Permite avanzar al siguiente nodo (recorrido hacia adelante)
     */
    @Override
    public boolean hasNext() {
        // Siempre hay un siguiente en una lista circular, a menos que esté vacía
        return inicio != null;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        E contenido = actual.getContenido();
        
        // Si ya dimos la vuelta completa, detenemos.
        if (inicioRecorrido && actual == inicio) {
            throw new NoSuchElementException("Fin del recorrido circular");
        }

        inicioRecorrido = true;
        actual = actual.getSiguiente();
        return contenido;
    }

    /**
     * Método adicional para recorrer hacia atrás (Requisito 5: iterar hacia atrás)
     * @return 
     */
    public boolean hasPrevious() {
        return hasNext(); // Aplica la misma lógica para lista circular
    }

    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        
        // En lugar de usar getSiguiente(), usamos getAnterior()
        E contenido = actual.getAnterior().getContenido(); 
        
        // Actualizamos el puntero 'actual'
        actual = actual.getAnterior();
        
        return contenido;
    }
}
