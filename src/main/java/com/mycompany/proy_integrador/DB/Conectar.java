/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador.DB;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Usuario
 */
public class Conectar{  //Es un intermediario con las clases que manejan la persistencia

    public static final String URL = "jdbc:mysql://localhost:3306/bd_tp";
    public static final String USER = "root";
    public static final String CLAVE = "dbamarcio";

    public Conectar() {
    }  

    public Connection getConexion() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

}
