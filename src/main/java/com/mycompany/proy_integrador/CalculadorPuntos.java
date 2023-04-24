/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import lombok.AllArgsConstructor;
import static com.mycompany.proy_integrador.Pronostico.pronosticos;
import static com.mycompany.proy_integrador.Participante.participantes;


@AllArgsConstructor
public class CalculadorPuntos {

    public void calcularPuntajes() {

        EstrategiaAsignacionPuntos est_ronda = new EstrategiaAsignacionxRonda();
        EstrategiaAsignacionPuntos est_fase = new EstrategiaAsignacionxFase();
        for (Participante p : participantes) {
            int puntos = 0;
            for (Pronostico pro : pronosticos) {
                if (pro.getParticipante().equals(p)) {
                    puntos += pro.puntos();

                }
            }
            puntos += est_ronda.obtenerPuntos(pronosticos, p) + est_fase.obtenerPuntos(pronosticos, p);
            p.setPuntos(puntos);
        }
    }

    public void mostrarPuntajes() {
        this.calcularPuntajes();
        for (int i = 0; i < participantes.size(); i++) {
            if (i > 0 && participantes.get(i).getPuntos() > participantes.get(i - 1).getPuntos()) {
                Participante menor = participantes.get(i - 1);
                participantes.set(i - 1, participantes.get(i));
                participantes.set(i, menor);
            }
          
        }

        System.out.println("\nPuntos por participante\n");

        for (Participante p : participantes) {
            System.out.println(p.getNombre() + " " + p.getApellido() + " " + p.getPuntos() + " puntos");

        }

    }
}
