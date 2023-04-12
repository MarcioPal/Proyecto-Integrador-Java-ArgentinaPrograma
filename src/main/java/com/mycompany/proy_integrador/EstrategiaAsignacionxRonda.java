/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class EstrategiaAsignacionxRonda implements EstrategiaAsignacionPuntos {

    @Override
    public int obtenerPuntos(ArrayList<Pronostico> pronosticos, ArrayList<Fase> fases) {
        int puntosExtra = 0;
        for (Fase f : fases) {
            for (Ronda r : f.getRondas()) {
                int aciertosRonda = 0;
                for (Pronostico pro : pronosticos) {
                    if (r.getPartidos().contains(pro.getPartido()) && pro.getPartido().resultado(pro.getEquipo()) == pro.getResultado()) {
                        ++aciertosRonda;
                    }
                }
                if (aciertosRonda == r.getPartidos().size()) {
                    ++puntosExtra;
                }
            }
        }
        return puntosExtra;
    }

}
