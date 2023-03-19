/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;
import java.io.IOException;


/**
 *
 * @author Usuario
 */
public class Main{
    public static void main(String[] args ) throws IOException, ClassNotFoundException{
 
        ObjectInput rondaInput = new ObjectInput();
        rondaInput.abrir("ronda");
        Ronda ronda = (Ronda) rondaInput.leer();
        rondaInput.cerrar();
        
        System.out.println("Resultados de la Ronda nro: "+ronda.getNro()+"\n");
        for(Partido p : ronda.getPartidos()){
            System.out.println(p.getEquipo1().getNombre()+" "+p.getGolesEquipo1()+"   "+p.getGolesEquipo2()+" "+p.getEquipo2().getNombre()+"\n");
        }
        
        
       ObjectInput obj = new ObjectInput();
       obj.abrir("pronosticos");
       Pronostico[] pronosticos = (Pronostico[]) obj.leer();
       //pronosticos[2].setResultado(GANADOR);
       
        System.out.println("Pronosticos realizados: \n");
        int puntosTotales = 0;
       for(Pronostico pro : pronosticos){
           System.out.println(pro.getEquipo().getNombre() +" "+pro.getResultado()+ "\n");
           puntosTotales += pro.puntos();
       }
        System.out.println("Ha obtenido: "+puntosTotales+" puntos");
       
       
       
        
    } 
}
