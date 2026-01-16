/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecotrack;

/**
 *
 * @author Usuario
 */
public class Nodo {
    private Residuo dato;  
    private Nodo siguiente; 
    
    public Nodo(Residuo dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Residuo getResiduo() { return dato; }
    public void setResiduo(Residuo dato) { this.dato = dato; }

    public Nodo getSiguiente() { return siguiente; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
}

