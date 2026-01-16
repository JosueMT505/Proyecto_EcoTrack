/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecotrack;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Estadisticas implements Serializable {
    private Map<String, Double> pesoPorTipo;
    private Map<String, Integer> residuosPorZona;

    public Estadisticas() {
        this.pesoPorTipo = new HashMap<>();
        this.residuosPorZona = new HashMap<>();
    }

    public void registrarResiduo(Residuo r) {
        pesoPorTipo.put(r.getTipo(), pesoPorTipo.getOrDefault(r.getTipo(), 0.0) + r.getPeso());
        residuosPorZona.put(r.getZona(), residuosPorZona.getOrDefault(r.getZona(), 0) + 1);
    }

    public Map<String, Double> obtenerPesoTotalPorTipo() {
        return pesoPorTipo;
    }

    public String zonaConMasResiduos() {
        String zonaTop = "N/A";
        int max = -1;
        for (Map.Entry<String, Integer> entry : residuosPorZona.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                zonaTop = entry.getKey();
            }
        }
        return zonaTop;
    }
}
