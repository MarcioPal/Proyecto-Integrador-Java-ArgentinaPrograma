/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import static com.mycompany.proy_integrador.ResultadoEnum.GANADOR;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pronostico implements Serializable{
    
    private Long id;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;
    private Participante participante;
    
    public int puntos(){
        int puntos = 0;
        if(partido.resultado(equipo) == resultado){
            ++puntos;
        }
        return puntos;
    }
}
