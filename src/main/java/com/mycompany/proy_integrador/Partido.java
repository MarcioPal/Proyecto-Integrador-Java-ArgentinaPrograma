/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import static com.mycompany.proy_integrador.ResultadoEnum.GANADOR;
import static com.mycompany.proy_integrador.ResultadoEnum.PERDEDOR;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Partido implements Serializable{
    
   
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    
    
    public ResultadoEnum resultado(Equipo equipo){
        if((equipo.equals(this.equipo1) && this.golesEquipo1 > this.golesEquipo2)
            || (equipo.equals(this.equipo2) && this.golesEquipo2 > this.golesEquipo1)){
            return GANADOR;
        }else{
        return PERDEDOR;
        }
    }
}
