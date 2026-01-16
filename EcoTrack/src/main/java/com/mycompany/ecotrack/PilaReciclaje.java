package com.mycompany.ecotrack;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * Pila LIFO para residuos a procesar (centro de reciclaje).
 * Implementada con ArregloDinamico propio (sin java.util.ArrayList).
 */
public class PilaReciclaje<Residuo> implements Serializable {
    private static final long serialVersionUID = 1L;
    private final ArrayList<Residuo> elementos;
    private Nodo cima;

    public PilaReciclaje() {
        this.elementos = new ArrayList<Residuo>();
    }

    public ArrayList<Residuo> getElementos() {
        return elementos;
    }
    
    public void apilarResiduo(Residuo elemento) {
        elementos.addLast(elemento);
    }
    
    public Residuo desapilarResiduo() {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila de reciclaje esta vacia.");
        }
        return elementos.removeLast();
    }

    public Residuo verTope() {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila de reciclaje esta vacia.");
        }
        return elementos.get(elementos.size() - 1);
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }

}
