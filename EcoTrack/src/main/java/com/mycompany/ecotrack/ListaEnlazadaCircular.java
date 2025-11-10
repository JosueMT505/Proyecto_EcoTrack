
package com.mycompany.ecotrack;

import java.util.Comparator;


public class ListaEnlazadaCircular<E> implements Iterable<E>{
    private Nodo<E> cabeza;
    private int tamanio;

    public ListaEnlazadaCircular() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    public void agregar(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            Nodo<E> ultimo = cabeza.getAnterior();
            
            nuevoNodo.setSiguiente(cabeza);
            nuevoNodo.setAnterior(ultimo);

            cabeza.setAnterior(nuevoNodo);
            ultimo.setSiguiente(nuevoNodo);
        }
        tamanio++;
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public int getTamanio() {
        return tamanio;
    }


    @Override
    public IteradorListaCircular<E> iterator() {
        return new IteradorListaCircular<>(cabeza);
    }


    public void ordenar(Comparator<E> comparador) {
        if (tamanio <= 1) return;

        for (int i = 0; i < tamanio - 1; i++) {
            Nodo<E> actual = cabeza;
            for (int j = 0; j < tamanio - 1 - i; j++) {
                
                if (comparador.compare(actual.getContenido(), actual.getSiguiente().getContenido()) > 0) {
                    
                    E temp = actual.getContenido();
                    actual.setContenido(actual.getSiguiente().getContenido());
                    actual.getSiguiente().setContenido(temp);
                }
                actual = actual.getSiguiente();
            }
        }
    }
}
