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

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Fase {
    private int nroFase;
    private ArrayList<Ronda> rondas;
    public static ArrayList<Fase> fases = new ArrayList<>();
    
    public Fase(int nroFase){
        this.nroFase = nroFase;
        this.rondas = new ArrayList<>();
    }
    
    public static Fase buscarFasePorNro(ArrayList<Fase> fases, int nroFase){
        for(Fase f: fases){
            if(f.getNroFase() == nroFase){
              return f;
            }
        }
        return null;
    }
   
}
