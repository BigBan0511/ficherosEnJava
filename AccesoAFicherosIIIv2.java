package accesoaficherosi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AccesoAFicherosIIIv2 {

    public static void main(String[] args) {
        String fileName = "output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Escribir líneas en el archivo
            writer.write("¡Hola, mundo!");
            writer.newLine(); // Escribir una nueva línea
            writer.write("Este es un ejemplo de BufferedWriter en Java.");
            writer.newLine(); // Escribir una nueva línea
            writer.write("¡Espero que te sea útil!");

            System.out.println("Datos escritos correctamente en el archivo: " + fileName);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
}
