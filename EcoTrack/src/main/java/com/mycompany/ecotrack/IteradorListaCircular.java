
package com.mycompany.ecotrack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Grupo 8
 */
public class IteradorListaCircular<E> implements Iterator<E> {
    private Nodo<E> inicio; 
    private Nodo<E> actual;
    private boolean inicioRecorrido = false;

    public IteradorListaCircular(Nodo<E> cabeza) {
        this.inicio = cabeza;
        this.actual = cabeza;
    }


    @Override
    public boolean hasNext() {
        return inicio != null;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        E contenido = actual.getContenido();
        
        if (inicioRecorrido && actual == inicio) {
            throw new NoSuchElementException("Fin del recorrido circular");
        }

        inicioRecorrido = true;
        actual = actual.getSiguiente();
        return contenido;
    }


    public boolean hasPrevious() {
        return hasNext(); 
    }

    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        
        E contenido = actual.getAnterior().getContenido(); 
        
        actual = actual.getAnterior();
        
        return contenido;
    }
}
