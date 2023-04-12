/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Participante {
    
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
    public static  ArrayList<Participante> participantes = new ArrayList<>();
    
    public Participante(String n, String ap, int dni){
        this.nombre = n;
        this.apellido = ap;
        this.dni = dni;
    }
    
        public static Participante buscarParticipantePorId(ArrayList<Participante> participantes, Long id) {
        for (Participante p : participantes) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
        
        public int getpuntosObtenidos(ArrayList<Pronostico> pronosticos, Participante p){
            int puntos = 0;
            for(Pronostico pro: pronosticos){
                if(pro.getParticipante().equals(p)){
                   puntos += pro.puntos();
                }
            }
            return puntos;
        }
    
}
