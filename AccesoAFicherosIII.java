package accesoaficherosi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccesoAFicherosIII {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Por favor, ingresa tu nombre:");
            String nombre = reader.readLine();
            System.out.println("¡Hola, " + nombre + "!");

            System.out.println("Por favor, ingresa tu edad:");
            int edad = Integer.parseInt(reader.readLine());
            System.out.println("Tu edad es: " + edad);
        } catch (IOException e) {
            System.err.println("Error al leer la entrada: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error: Ingresa un número válido para la edad.");
        } finally {
            try {
                // Cerrar el BufferedReaderEjemplo al finalizar su uso
                reader.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el BufferedReader: " + e.getMessage());
            }
        }
    }
    
}
