/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaDeDirectorios;

import java.io.File;

/**
 *
 * @author AARON
 */
public class LeerDirectorio {
    
    public static void setDirectorio(String directorioBase){
        File dirBase = new File(directorioBase);
        if(dirBase.isDirectory()){
            String[] ficheros = dirBase.list();
            if (ficheros == null){
                System.out.println("No hay ficheros en el directorio especificado");
            }
            else{
                 for (int x=0;x < ficheros.length;x++){
                    File dir_or_file = new File(dirBase.getAbsolutePath() + "\\" + ficheros[x]);
                    if(dir_or_file.isDirectory()){
                        LeerDirectorio.setDirectorio(dirBase.getAbsolutePath() + "\\" + ficheros[x]);
                    }
                    else if(dir_or_file.isFile()){
                        System.out.println(dirBase.getAbsolutePath() + "\\" + ficheros[x]);
                    }
                    else{
                        System.out.println("Tipo no encontrado");
                    }
                 }
            }
        }
        else{
            System.out.println(directorioBase + " no es un directorio");
        }
    }
}
