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
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Equipo implements Serializable {
    
    private Long id;
    private String nombre;
    private String descripcion;
    
    public Equipo(String nom,String desc){
        this.nombre = nom;
        this.descripcion = desc;
    }
    
       public static Equipo buscarEquipoPorId(ArrayList<Equipo> equipos, Long id) {
        for (Equipo eq : equipos) {
            if (eq.getId() == id) {
                return eq;
            }
        }
        return null;
    }
}
