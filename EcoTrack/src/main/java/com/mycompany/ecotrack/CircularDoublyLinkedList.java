/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecotrack;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.Serializable;

/**
 *
 * @author josue
 */
public class CircularDoublyLinkedList<E> implements Serializable {

    private DoublyNodeList<E> header;
    private int size;

    public CircularDoublyLinkedList() {
        header = null;
        size = 0;
    }

    /* =====================
       MÉTODOS BÁSICOS
       ===================== */

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return header == null;
    }

    public void clear() {
        header = null;
        size = 0;
    }


    public boolean addFirst(E e) {
        if (e == null) return false;

        DoublyNodeList<E> newNode = new DoublyNodeList<>(e);

        if (isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrevious(newNode);
            header = newNode;
        } else {
            DoublyNodeList<E> last = header.getPrevious();

            newNode.setNext(header);
            newNode.setPrevious(last);

            last.setNext(newNode);
            header.setPrevious(newNode);

            header = newNode;
        }
        size++;
        return true;
    }

    public boolean addLast(E e) {
        if (isEmpty()) {
            return addFirst(e);
        }

        DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
        DoublyNodeList<E> last = header.getPrevious();

        newNode.setNext(header);
        newNode.setPrevious(last);

        last.setNext(newNode);
        header.setPrevious(newNode);

        size++;
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(element);
            return;
        }

        if (index == size) {
            addLast(element);
            return;
        }

        DoublyNodeList<E> current = header;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        DoublyNodeList<E> newNode = new DoublyNodeList<>(element);

        newNode.setNext(current);
        newNode.setPrevious(current.getPrevious());

        current.getPrevious().setNext(newNode);
        current.setPrevious(newNode);

        size++;
    }



    public E removeFirst() {
        if (isEmpty()) return null;

        E data = header.getContent();

        if (size == 1) {
            clear();
            return data;
        }

        DoublyNodeList<E> last = header.getPrevious();
        header = header.getNext();

        header.setPrevious(last);
        last.setNext(header);

        size--;
        return data;
    }

    public E removeLast() {
        if (isEmpty()) return null;

        if (size == 1) {
            return removeFirst();
        }

        DoublyNodeList<E> last = header.getPrevious();
        E data = last.getContent();

        last.getPrevious().setNext(header);
        header.setPrevious(last.getPrevious());

        size--;
        return data;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        DoublyNodeList<E> current = header;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());

        size--;
        return current.getContent();
    }

    public DoublyNodeList<E> getHeaderNode() {
        return header;
    }

    public DoublyNodeList<E> getLastNode() {
        return (header == null) ? null : header.getPrevious();
    }


    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        DoublyNodeList<E> current = header;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getContent();
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        DoublyNodeList<E> current = header;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        E old = current.getContent();
        current.setContent(element);
        return old;
    }
    
    public boolean checkIntegrity() {
        if (isEmpty()) return true;

        DoublyNodeList<E> current = header;
        int count = 0;

        do {
            if (current.getNext().getPrevious() != current) return false;
            if (current.getPrevious().getNext() != current) return false;

            current = current.getNext();
            count++;
        } while (current != header);

        return count == size;
    }


    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        DoublyNodeList<E> current = header;

        do {
            sb.append(current.getContent());
            current = current.getNext();
            if (current != header) sb.append(", ");
        } while (current != header);

        sb.append("]");
        return sb.toString();
    }
}
