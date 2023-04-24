/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import java.util.ArrayList;
import static com.mycompany.proy_integrador.Fase.fases;

/**
 *
 * @author Usuario
 */
public class EstrategiaAsignacionxFase implements EstrategiaAsignacionPuntos {

    @Override
    public int obtenerPuntos(ArrayList<Pronostico> pronosticos, Participante p) {

        int puntosExtra = 0;
        
        for (Fase f : fases) {
            int cantAciertosFase = 0;
            for (Ronda r : f.getRondas()) {
                int cantAciertosRonda = 0;
                for (Pronostico pro : pronosticos) {
                    if (pro.getParticipante()== p && r.contienePartido(pro.getPartido()) && pro.getPartido().resultado(pro.getEquipo()).equals(pro.getResultado())) {
                        ++cantAciertosRonda;
                    }
                }
                if (cantAciertosRonda == r.getPartidos().size()) {
                      ++cantAciertosFase;
                }
            }
            if(cantAciertosFase == f.getRondas().size()){
                ++puntosExtra;
                System.out.println(cantAciertosFase);
            }
        }
        
        return puntosExtra;
    }
}
