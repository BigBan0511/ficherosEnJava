package accesoaficherosi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccesoAFicherosV {
    
    public static void escribeBuffer(){
        try {
            Scanner datos = new Scanner(System.in);
            FileWriter miEscritor = new FileWriter("C:/Users/GSW1A8570413/Desktop/A.txt",true);
            BufferedWriter miBuffer = new BufferedWriter(miEscritor);
            System.out.println("Introduce una cadena");
            String laFrase = datos.nextLine();
            miBuffer.write(laFrase);
            miBuffer.newLine();
            miBuffer.close();
            miEscritor.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public static void main(String[] args) {
        escribeBuffer();
    }
    
}
