package accesoficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class EjerciciosBuffered {

    public static void leeBuffer(){
        try{
            //PASO 1: Generamos el flujo
            FileReader miLector=new FileReader("C:\\Users\\alejandro\\desktop\\EjemploEscritura.txt");
            //PASO 2: Creamos el buffer
            BufferedReader miBuffer=new BufferedReader(miLector);
            String linea="";
            while(linea!=null){
                //Vamos leyendo linea a linea hasta que encontramos que se lee null
                linea=miBuffer.readLine();
                if(linea!=null)
                    System.out.println(linea);
            }
            miBuffer.close();
            miLector.close();
        }catch(IOException e){
            System.out.println("Problemas al acceder al archivo: " + e.getMessage());
        }
    }
    
    public static void escribeBuffer(){
        try{
            FileWriter miEscritor=new FileWriter("C:\\Users\\alejandro\\desktop\\EjemploEscritura.txt", true);
            BufferedWriter miBuffer=new BufferedWriter(miEscritor);
            String laFrase="\nBUENOS DIAS jdfpbj apodf jbp japdofjbpoajdfb";
            miBuffer.write(laFrase);
            miBuffer.close();
            miEscritor.close();
        }catch(IOException e){
            System.out.println("Problemas al acceder al archivo: " + e.getMessage());
        }
    }
    
    public static void escribirAVoluntad(){
        Scanner datos=new Scanner(System.in);
        try{
            FileWriter miEscritor=new FileWriter("C:\\Users\\alejandro\\desktop\\voluntad.txt", true);
            BufferedWriter miBuffer=new BufferedWriter(miEscritor);
            boolean salida=false;
            String opcion="";
            do{
                datos=new Scanner(System.in);
                System.out.println("Escribe la frase que deseas llevar al archivo:");
                String frase=datos.nextLine();
                miBuffer.write(frase + "\n");
                do{
                    System.out.println("¿Deseas escribir otra frase?");
                    opcion=datos.next();
                    if(opcion.equalsIgnoreCase("no"))
                        salida=true;
                }while(!opcion.equalsIgnoreCase("si") && !opcion.equalsIgnoreCase("no"));
                
            }while(salida==false);
            miBuffer.close();
            miEscritor.close();
        }catch(IOException e){
            System.out.println("Problemas de I/O: " + e.getMessage());
        }
    }
   
    public static void main(String[] args) {
        //escribeBuffer();
        //leeBuffer();
        escribirAVoluntad();
    }

}
