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
public class EstrategiaAsignacionxFase implements EstrategiaAsignacionPuntos {

    @Override
    public int obtenerPuntos(ArrayList<Pronostico> pronosticos, ArrayList<Fase> fases) {

        int puntosExtra = 0;
        
        for (Fase f : fases) {
            int cantAciertosFase = 0;
            for (Ronda r : f.getRondas()) {
                int cantAciertosRonda = 0;
                for (Pronostico p : pronosticos) {
                    if (r.getPartidos().contains(p.getPartido()) && p.getPartido().resultado(p.getEquipo()) == p.getResultado()) {
                        ++cantAciertosRonda;
                    }
                }
                if (cantAciertosRonda == r.getPartidos().size()) {
                      ++cantAciertosFase;
                }
            }
            if(cantAciertosFase == f.getRondas().size()){
                ++puntosExtra;
            }
        }
        
        return puntosExtra;
    }
}
