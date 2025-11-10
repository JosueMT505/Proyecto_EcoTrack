/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.estructuras;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Usuario
 * @param <E>
 */
public class PilaReciclaje<E> {
    private ArrayList<E> elementos;

    public PilaReciclaje() {
        this.elementos = new ArrayList<>();
    }

    /**
     * Agrega un elemento a la cima de la pila (LIFO).
     * @param elemento El residuo a ser procesado.
     */
    public void push(E elemento) {
        // En un ArrayList, la cima es el final (add)
        elementos.add(elemento);
    }

    /**
     * Remueve y devuelve el elemento en la cima de la pila (LIFO).
     * @return El elemento más reciente agregado.
     */
    public E pop() {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila de reciclaje está vacía.");
        }
        // El elemento en la cima (el último)
        int indiceCima = elementos.size() - 1;
        
        // Retorna y remueve el elemento de la cima
        return elementos.remove(indiceCima);
    }

    /**
     * Devuelve el elemento en la cima de la pila sin removerlo.
     * @return El elemento más reciente agregado.
     */
    public E peek() {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila de reciclaje está vacía.");
        }
        // Devuelve el elemento en la cima sin remover
        int indiceCima = elementos.size() - 1;
        return elementos.get(indiceCima);
    }

    /**
     * Verifica si la pila está vacía.
     */
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    /**
     * Devuelve el número de elementos en la pila.
     */
    public int size() {
        return elementos.size();
    }
}
