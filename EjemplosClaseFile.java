package accesoficheros;

import java.io.File;

public class EjemplosClaseFile {   
    public static void main(String[] args) {
        File ruta=new File("C:\\Users\\alejandro\\Documents\\NetBeansProjects");
        if(ruta.isDirectory()){
            System.out.println(ruta.getAbsoluteFile() + " es un drectorio");
            //Guarda en el array el contenido de la ruta
            String[] contenido=ruta.list();
            for(String actual : contenido){
                System.out.println(actual);
            }
        }
        else if(ruta.isFile())
            System.out.println(ruta.getAbsoluteFile() + " es un archivo");
        else
            System.out.println("El PATH no existe");
        System.out.println("El tamaño del archivo es: " + ruta.length());
        
        
    }

}
