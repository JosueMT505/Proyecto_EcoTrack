/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecotrack;

/**
 *
 * @author joshu
 */
public class ArrayList<E>{
    private int capacity;
    private int effectiveSize;
    private E[] elements; //Arreglo donde se almacenan los elementos de tipo E(genericos)
    
    public ArrayList() {
        this.capacity =  100;
        this.effectiveSize = 0;
        this.elements = (E[]) new Object[capacity];
    }
    
    
    public int size(){
        return effectiveSize; //Devuelve la cantidad de elementos que actualmente hay en el ArrayList
    }
    
    public boolean isEmpty(){
        return effectiveSize == 0;
    }
    
    public void clear() {
        for(int i=0; i<effectiveSize; i++){
            elements[i]=null;
        }
        effectiveSize = 0;
    }
    
    public E get(int index){
        if(index < 0 || index >= effectiveSize){
            throw new IndexOutOfBoundsException("Index: "+index);
        }
        return elements[index];
    }
    
    public E set(int index, E element) {
        if(index<0 || index>= effectiveSize) {
            throw new IndexOutOfBoundsException("Index: "+ index);
        }
        E elementBefore = elements[index];
        elements[index] = element;
        return elementBefore;
    }
    
    public boolean addLast(E e){
        if(e==null){
            return false;
        } else if (isFull()){
            addCapacity();
        }
        
        elements[effectiveSize] = e;
        effectiveSize++;
        return true;
    }
    
    public boolean addFirst(E e){
        if (e == null) return false;

        if (isFull()) {
            addCapacity();
        }

        for (int i = effectiveSize; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = e;
        effectiveSize++;
        return true;
    }
    
    public boolean isFull(){
        return capacity == effectiveSize;
    }
    
    public void addCapacity(){
        E[] tmp = (E[]) new Object[capacity * 2];
        for(int i= 0; i < capacity; ++i){
            tmp[i] = elements[i];
        }
        elements = tmp;
        capacity = capacity *2;
    }
    

    public void add(int index, E element){
        if(element==null || index<0 || index>effectiveSize){
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        else if (isFull()){
            addCapacity();
        }
        for(int i = effectiveSize - 1; i>=index; i--){
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        effectiveSize++;
    }
    
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E element = elements[0];
        for(int i = 1; i<effectiveSize; i++){
            elements[i-1] = elements[i];
        }
        effectiveSize--;
        return element;
    }
    
    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        E elementLast = elements[effectiveSize - 1];
        elements[effectiveSize - 1] = null;
        effectiveSize--;
        return elementLast;
    }
    
    public E remove(int index){
        if(index < 0 || index >= effectiveSize){
            throw new IndexOutOfBoundsException("Index: "+ index);
        }
       E elementremove = elements[index];
       for(int i = index; i<effectiveSize-1; i++){
           elements[i] = elements[i+1];
       }
       elements[effectiveSize-1]=null;
       effectiveSize--;
       return elementremove;
    }
    
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        String result = "[";
        for(int i = 0; i < effectiveSize; i++){
            result += elements[i];   // concatenamos el elemento

        // Agregamos coma y espacio si NO es el último
            if (i < effectiveSize - 1) {
                result += ", ";
            }
        }

        result += "]";
        return result;
    }
}