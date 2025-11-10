/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo_08.comparadores;

import Grupo_08.modelo.Residuo;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class ComparadorPeso implements Comparator<Residuo> {
    @Override
    public int compare(Residuo r1, Residuo r2) {
        return Double.compare(r1.getPeso(), r2.getPeso());
    }
}
