
package com.mycompany.ecotrack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Grupo 8 
 */
public class PilaReciclaje<E> {
    private ArrayList<E> elementos;

    public PilaReciclaje() {
        this.elementos = new ArrayList<>();
    }


    public void push(E elemento) {
        elementos.add(elemento);
    }

    /**
     * Remueve y devuelve el elemento en la cima de la pila (LIFO).
     * devuelve el elemento más reciente agregado.
     */
    public E pop() {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila de reciclaje está vacía.");
        }
        int indiceCima = elementos.size() - 1;
        
        return elementos.remove(indiceCima);
    }

    /**
     * Devuelve el elemento en la cima de la pila sin removerlo.
     * devuelve el elemento más reciente agregado.
     */
    public E peek() {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila de reciclaje está vacía.");
        }
        int indiceCima = elementos.size() - 1;
        return elementos.get(indiceCima);
    }


    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }
}
