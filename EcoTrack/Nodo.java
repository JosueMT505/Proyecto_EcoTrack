/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.estructuras;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class Nodo<E> {
    private E contenido;
    private Nodo<E> siguiente;
    private Nodo<E> anterior;

    // Constructor
    public Nodo(E contenido) {
        this.contenido = contenido;
        // Inicialmente, en la lista circular los punteros serán establecidos por la propia lista.
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
