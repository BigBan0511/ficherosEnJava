package accesoaficherosi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccesoAFicherosVI {
    public static Scanner datos = new Scanner(System.in);
    
    public static void escribir(){
        try {
            FileWriter f1 = new FileWriter("C:/Users/GSW1A8570413/Desktop/A.txt",true);
            BufferedWriter b1 = new BufferedWriter(f1);
            System.out.println("Introduce una cadena");
            String cadena = datos.nextLine();
            b1.write(cadena);
            b1.newLine();
            b1.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public static void main(String[] args) {
        String respuesta = "";
        do{
            escribir();
            System.out.println("Desea continuar?");
            respuesta = datos.nextLine();
        }while(respuesta.equalsIgnoreCase("S") || !respuesta.equalsIgnoreCase("N"));
    }
    
}
