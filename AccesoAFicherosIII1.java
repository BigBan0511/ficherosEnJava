package accesoaficherosiii;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccesoAFicherosIII {

    public static void main(String[] args) {
        System.out.println("INFORMACIÓN SOBRE ESTE FICHERO");
        File archivoActual = new File ("C:/Users/GSW1A8570413/Desktop/A.txt");
        if (archivoActual.exists()){
        System.out.println("Nombre del fichero: " + archivoActual.getName());
        System.out.println("Ruta del fichero: " + archivoActual.getPath());
        System.out.println("Ruta absoluta del fichero: " + archivoActual.getAbsolutePath());
        System.out.println("Sepuede leer: "+ archivoActual.canRead());
        System.out.println("Se puede escribir: " + archivoActual.canWrite());
        System.out.println("Tamaño del fichero: " + archivoActual.length ());
        System.out.println("Es un directorio: " + archivoActual.isDirectory()); 
        System.out.println("Es un fichero: "+ archivoActual.isFile());
        }
        else
            System.out.println("El fichero no existe");
        
        //MOSTRAR EL CONTENIDO DE UNA CARPETA
        File ruta = new File("C:/Users/GSW1A8570413/Desktop/carmina"); 
        System.out.println(ruta.exists());
        //Como convertir una Array de String en una ArrayList
        List <String> misDocumentos = new ArrayList<>();
        String [] miStringArchivo = ruta.list(); //Me devuelve un array con el contenido 
        Collections.addAll(misDocumentos, miStringArchivo);
        for (String e : misDocumentos) {
            System.out.println(e);
        }
    }
    
}
