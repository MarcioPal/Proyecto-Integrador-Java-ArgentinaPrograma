/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proy_integrador;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Usuario
 */
public class ObjectInput {
    private FileInputStream file;
 private ObjectInputStream input;
 public void abrir(String fileName)
 throws IOException
 {
 file = new FileInputStream( fileName+".ser" );
 input = new ObjectInputStream (file);
 }
 public void cerrar()
 throws IOException
 {
 if (input!=null )
 input.close();
 }
 public Object leer ()
 throws IOException, ClassNotFoundException
 {
 Object obj = null;
 if (input!=null) {
 try {
 obj = (Object) input.readObject();
 } catch (EOFException eof) {
 // Fin del fichero
 }
 }
 return obj;
 }
}
