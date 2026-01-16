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
public class ListaCircularResiduos implements Serializable {
    private Nodo inicio;
    private final CircularDoublyLinkedList<Residuo> lista;

    public ListaCircularResiduos() {
        this.lista = new CircularDoublyLinkedList<>();
    }

    /**
     * Agrega un residuo al final de la lista.
     * (Opcional) Evita IDs repetidos si el id no es null.
     */
    public boolean agregarResiduo(Residuo r) {
        if (r == null) return false;

        // Evitar IDs repetidos (puedes quitar esto si no lo piden)
        if (r.getId() != null && buscarResiduo(r.getId()) != null) {
            return false;
        }

        return lista.addLast(r);
    }

    /**
     * Elimina el residuo que tenga el id indicado.
     * @return true si se eliminó, false si no se encontró o lista vacía.
     */
    public boolean eliminarResiduo(String id) {
        if (id == null || lista.isEmpty()) return false;

        int index = indexOfId(id);
        if (index == -1) return false;

        lista.remove(index);
        return true;
    }

    /**
     * Busca un residuo por id.
     * @return el Residuo si existe, o null si no se encuentra.
     */
    public Residuo buscarResiduo(String id) {
        if (id == null || lista.isEmpty()) return null;

        for (int i = 0; i < lista.size(); i++) {
            Residuo r = lista.get(i);
            if (r != null && id.equals(r.getId())) {
                return r;
            }
        }
        return null;
    }

    /**
     * Indica si la lista está vacía.
     */
    public boolean estaVacia() {
        return lista.isEmpty();
    }

    /**
     * Retorna el número de elementos.
     */
    public int size() {
        return lista.size();
    }

    public java.util.ArrayList<Residuo> getResiduos() {
    java.util.ArrayList<Residuo> lista = new java.util.ArrayList<>();
    if (inicio != null) {
        Nodo actual = inicio;
        do {
            lista.add(actual.getResiduo());
            actual = actual.getSiguiente();
        } while (actual != inicio);
    }
    return lista;
}
    
    /**
     * Retorna el primer residuo (o null si está vacía).
     */
    public Residuo getPrimero() {
        if (lista.isEmpty()) return null;
        return lista.get(0);
    }

    public CircularDoublyLinkedList<Residuo> getListaInterna() {
    return lista;
}
    
    /**
     * (Opcional) Devuelve el iterador personalizado para recorrer la lista.
     */
    public IteradorResiduos<Residuo> iterador() {
        return new IteradorResiduos<>(lista);
    }

    /**
     * Método auxiliar: devuelve el índice del residuo con ese id, o -1 si no existe.
     */
    private int indexOfId(String id) {
        for (int i = 0; i < lista.size(); i++) {
            Residuo r = lista.get(i);
            if (r != null && id.equals(r.getId())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return lista.toString();
    }
    
    public Nodo getInicio() {
        return inicio; 
    }
    
    
}
