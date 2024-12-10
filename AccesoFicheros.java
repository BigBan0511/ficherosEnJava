package accesoficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccesoFicheros {
    
    public static boolean escribir(String frase){
        try{
            //Generamos el flujo de salida hacia el archivo
            FileWriter miEscritor=new FileWriter("C:\\Users\\alejandro\\desktop\\EjemploEscritura.txt",true);
            //Si ponemos true al final del constructor, añade la info al final del archivo
            //Hacemos un bucle que recorrerá la frase e irá añadiendo cada caracter de la frase al archivo
            for(int x=0; x<frase.length();x++)
                //Vamos escribiendo cada caracter de la frase, teniendo en cuenta que un caracter puede
                //ser un char
                miEscritor.write(frase.charAt(x));
            miEscritor.close();
            return true;
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }
        catch(IOException e){
            System.out.println("Problemas al escribir el archivo");
        }
        return false;
    } 

    public static String lee(){
        String lectura="";
        try {
            //FileReader Genera el flujo de entrada entre el archivo y el programa
            //FileReader miLector= new FileReader("/Users/alejandro/Desktop/Ejemplo.txt");
            FileReader miLector= new FileReader("C:\\Users\\alejandro\\Desktop\\Ejemplo.txt");
            //El read() lee el siguiente caracter.
            int caracter=miLector.read();
            lectura=lectura+(char)caracter;
            while(caracter!=-1){
                //Cuando termina el archivo la lectura con read() devuvleve -1
                caracter=miLector.read();
                if(caracter!=-1)
                    //Debemos castear a char sino pegará el int
                    lectura=lectura+(char)caracter;
            }
            //Es necesario cerrar los flujos de datos cuando hemos terminado de usar el archivo
            miLector.close();
            return lectura;
        }
        catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo especificado");
        }catch(IOException e){
            System.out.println("Error al leer el archivo");
        }
        return lectura;
    }
    public static void main(String[] args) {
        //System.out.println(lee());
        System.out.println(escribir("Otra línea"));
    }

}
