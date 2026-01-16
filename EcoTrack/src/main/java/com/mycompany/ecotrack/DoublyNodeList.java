/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecotrack;
import java.io.Serializable;

/**
 *
 * @author josue
 */
public class DoublyNodeList<E> implements Serializable {
    private E content;
    private DoublyNodeList<E> next;
    private DoublyNodeList<E> prev;

    public DoublyNodeList(E content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public DoublyNodeList<E> getNext() {
        return next;
    }

    public void setNext(DoublyNodeList<E> next) {
        this.next = next;
    }

    public DoublyNodeList<E> getPrevious() {
        return prev;
    }

    public void setPrevious(DoublyNodeList<E> prev) {
        this.prev = prev;
    }   
}
