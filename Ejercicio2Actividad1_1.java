import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio2Actividad1_1 {

	public static void main(String[] args) {
		Scanner datos = new Scanner(System.in);
		String nombreArchivo;
		do {
			System.out.println("Introduce el nombre del archivo");
			nombreArchivo = datos.nextLine();
		}while(nombreArchivo.contains(" "));
		if(!nombreArchivo.contains(".txt")) {
			nombreArchivo = nombreArchivo + ".txt";
		}
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter escribir = new PrintWriter(new FileWriter(archivo));
			String texto = "";
			System.out.println("Si desea dejar de escribir introduzca 'exit' en la siguiente peticion");
			do {
				System.out.println("Introduzca el texto:");
				texto = datos.nextLine();
				if(!texto.equalsIgnoreCase("exit"))
					escribir.println(texto);
			} while (!texto.equalsIgnoreCase("exit"));
			escribir.close();
		} catch (IOException e) {
			System.out.println("El archivo no existe");
		}

	}

}
