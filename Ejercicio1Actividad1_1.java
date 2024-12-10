import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1Actividad1_1 {

	public static void main(String[] args) {
		Scanner datos = new Scanner(System.in);
		String nombre = null;
		String ruta = null;
		do {
			System.out.println("Introduce la ruta del archivo utilizando las barras '/'");
			ruta = datos.nextLine();
			if(!ruta.equals("/"))
				ruta = ruta + "/";
			System.out.println("Introduce el nombre del archivo");
			nombre = datos.nextLine();
		}while(nombre.contains(" "));
		try {
			BufferedReader fich = new BufferedReader(new FileReader(ruta + nombre));
			String lin;
			while((lin = fich.readLine())!=null) {
				System.out.println(lin);
			}
			fich.close();
			datos.close();
		} catch (IOException e) {
			System.out.println("El archivo no existe");
		}

	}

}
