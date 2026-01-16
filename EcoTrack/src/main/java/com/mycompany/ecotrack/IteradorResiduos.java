/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecotrack;

import java.util.NoSuchElementException;

public class IteradorResiduos<E> {

    private final CircularDoublyLinkedList<E> lista;

    private DoublyNodeList<E> cursor;   
    private int forwardCount;           
    private int backwardCount;          

    public IteradorResiduos(CircularDoublyLinkedList<E> lista) {
        if (lista == null) throw new IllegalArgumentException("La lista no puede ser null");
        this.lista = lista;
        this.cursor = null;
        this.forwardCount = 0;
        this.backwardCount = 0;
    }

    public boolean hasNext() {
        return forwardCount < lista.size();
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay siguiente elemento");
        }

        if (cursor == null) {
            cursor = lista.getHeaderNode();   // primer elemento
        } else {
            cursor = cursor.getNext();
        }

        forwardCount++;
        return cursor.getContent();
    }

    public boolean hasPrevious() {
        return backwardCount < lista.size();
    }

    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException("No hay elemento anterior");
        }

        if (cursor == null) {
            cursor = lista.getLastNode();     // último elemento
        } else {
            cursor = cursor.getPrevious();
        }

        backwardCount++;
        return cursor.getContent();
    }

    public void reset() {
        cursor = null;
        forwardCount = 0;
        backwardCount = 0;
    }
}

