
package com.mycompany.ecotrack;

/**
 *
 * @author Grupo 8
 */
public class Nodo<E> {
    private E contenido;
    private Nodo<E> siguiente;
    private Nodo<E> anterior;

    public Nodo(E contenido) {
        this.contenido = contenido;
        this.siguiente = null; 
        this.anterior = null;
    }

    // Getters y Setters
    public E getContenido() {
        return contenido;
    }

    public void setContenido(E contenido) {
        this.contenido = contenido;
    }

    public Nodo<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<E> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<E> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<E> anterior) {
        this.anterior = anterior;
    }
}
