/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import java.io.Serializable;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ronda{
    private int nro;
    private ArrayList<Partido> partidos;
    public static ArrayList<Ronda> rondas = new ArrayList<>();
      
    public int puntos(Pronostico pro){
        return 0;
    }
    
}
