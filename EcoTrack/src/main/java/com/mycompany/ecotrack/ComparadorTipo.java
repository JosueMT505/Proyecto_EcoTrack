
package com.mycompany.ecotrack;

import java.util.Comparator;

/**
 *
 * @author Grupo 8
 */
public class ComparadorTipo implements Comparator<Residuo> {
    @Override
    public int compare(Residuo r1, Residuo r2) {
        return r1.getTipo().compareTo(r2.getTipo());
    }
}
