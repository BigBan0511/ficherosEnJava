package accesoaficherosi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccesoAFicherosIV {
    
    public static void leeBuffer(){
        try {
            FileReader miLector = new FileReader("C:/Users/GSW1A8570413/Desktop/A.txt");
            BufferedReader miBuffer = new BufferedReader(miLector);
            String linea = "";
            while(linea!=null){
                linea = miBuffer.readLine();
                if(linea!=null){
                    System.out.println(linea);
                }
            }
            miBuffer.close();
            miLector.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }

    public static void main(String[] args) {
        leeBuffer();
    }
    
}
