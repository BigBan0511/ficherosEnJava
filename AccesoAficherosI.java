package accesoaficherosi;

import java.io.FileReader;
import java.io.IOException;

public class AccesoAficherosI {
    
    public static void lee(){
        try {
            //Si estamos en LINUX
            /*FileReader miLector = new FileReader("/Users/alejandrogonzalezredondo/Desktop/"
                    + "EjemplosLecturaFicheros/Ejemplo.txt");*/
            //Si estamos en WINDOWS
            FileReader miLector = new FileReader("C:/Users/GSW1A8570413/Desktop/A.txt");
            int caracter = miLector.read();
            while(caracter != -1){
                System.out.println(caracter);
                caracter = miLector.read();
            }
            miLector.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }finally{
            //Tenemos que cerrar los flujos a los archivos
        }
    }

    public static void main(String[] args) {
        //LeerFichero.lee();
        //1: Que no encuentra el archivo
        
        //2:
        lee();
        
        //3: Si quitamos el bloque try y catch puede saltar una excepcion si no encuentra el archivo
        
        //4: Hay que poner miLector.close() al final del try
    }
    
}
