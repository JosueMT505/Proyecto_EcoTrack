
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


    public void apilarResiduo(E elemento) {
        elementos.add(elemento);
    }


    public E desapilarResiduo() {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila de reciclaje está vacía.");
        }
        int indiceCima = elementos.size() - 1;
        
        return elementos.remove(indiceCima);
    }

    public E verTope() {
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
