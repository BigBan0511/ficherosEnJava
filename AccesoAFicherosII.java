package accesoaficherosi;

import java.io.FileWriter;
import java.io.IOException;

public class AccesoAFicherosII {
    
    public static void escribe(){
        try {
            //Si estamos en LINUX
            /*FileWriter miLector = new FileWriter("/Users/alejandrogonzalezredondo/Desktop/"
                    + "EjemplosLecturaFicheros/Ejemplo.txt");*/
            //Si estamos en WINDOWS
            FileWriter miEscritor = new FileWriter("D:/PROGRAMAS/OneDrive/Escritorio/archivo.txt");
            String laFrase = "Hola estamos escribiendo en un archivo";
            for (int x = 0; x < laFrase.length(); x++) {
                miEscritor.write(laFrase.charAt(x));
            }
            System.out.println("Escritura terminada");
            miEscritor.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public static void main(String[] args) {
        escribe();
        //1: Si existía algo escrito anteriormente, este texto es reemplazado por el nuevo
        //2: Si el archivo a escribir no existía, se crea un archivo solo
        
    }
    
}
