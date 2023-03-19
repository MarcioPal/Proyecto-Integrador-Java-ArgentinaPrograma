/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Usuario
 */
public class ObjectOutput {
    private FileOutputStream file; //Representa el archivo
 private ObjectOutputStream output;  //Representa un objeto de salida que puede almacenarse en disco
 // Abrir el fichero
 public void abrir(String fileName)
 throws IOException
 {
 file = new FileOutputStream( fileName+".ser" );  //Busca un archivo con el nombre especificado o lo crea
 output = new ObjectOutputStream(file);  //El obj Java apunta al archivo en disco el cual podemos escribir usando sus metodos
 }
 // Cerrar el fichero
 public void cerrar()  //Cerrar el archivo implica escribir de manera permanente (en disco) los cambios realizados
 throws IOException
 {
 if (output!=null)
 output.close();
 }
 // Escribir en el fichero
 public void escribir (Object obj)
 throws IOException
 {
 if (output!=null)
 output.writeObject(obj);
 }
}
