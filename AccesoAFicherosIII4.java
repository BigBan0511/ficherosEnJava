package accesoaficherosiii;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccesoAFicherosIII4 {
    public static Scanner datos = new Scanner(System.in);
    
    public static boolean generarDirectorio(String laRuta){
        File directorioNuevo = new File(laRuta);
        if(directorioNuevo.exists()){
            System.out.println("El directorio ya existe");
            return true;
        }else{
            directorioNuevo.mkdirs();
            return false;
        }
    }
    
    public static void crearArchivo(String laRutaConArchivo){
        try {
            File ff1 = new File(laRutaConArchivo);
            FileWriter f1 = new FileWriter(ff1);
        } catch (IOException e) {
            System.out.println("Fallo");
        }
    }
    
    public static void escribirArchivo(String laRutaConArchivo){
        try {
            File ff1 = new File(laRutaConArchivo + "\\lola.txt");
            FileWriter f1 = new FileWriter(ff1,true);
            BufferedWriter b1 = new BufferedWriter(f1);
            System.out.println("Que desea escribir en el archivo?");
            String cadena = datos.nextLine();
            b1.write(cadena);
            b1.newLine();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        String respuesta = "";
        String ruta = "F:\\PROYECTOS\\PROGRAMACION\\UsarFileEnJava\\ElLangis";
        generarDirectorio(ruta);
        crearArchivo(ruta);
        do{
            escribirArchivo(ruta);
            System.out.println("Desea continuar?");
            respuesta = datos.nextLine();
        }while(respuesta.equalsIgnoreCase("S") || !respuesta.equalsIgnoreCase("N"));
    }
    
}
