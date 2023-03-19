/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Equipo implements Serializable {
    private String nombre;
    private String descripcion;
    
    public Equipo(String nom,String desc){
        this.nombre = nom;
        this.descripcion = desc;
    }
}
