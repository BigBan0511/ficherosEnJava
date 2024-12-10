import java.io.File;
import java.io.IOException;

public class crearDirectorio {

	public static void main(String[] args) {
		File directorio = new File("directorioNuevo");
		File fichero1 = new File(directorio, "Fichero1.txt");
		File fichero2 = new File(directorio, "Fichero2.txt");
		directorio.mkdir();
		try {
			if (fichero1.createNewFile())
				System.out.println("El primer fichero ha sido creado");
			else
				System.out.println("No se ha creado el fichero 1");
			if (fichero2.createNewFile())
				System.out.println("El segundo fichero ha sido creado");
			else
				System.out.println("No se ha creado el fichero 2");
		} catch (IOException e) {
			e.printStackTrace();
		}
		fichero1.renameTo(new File(directorio, "nombreCambiado1.txt"));
		File fichero3 = new File("directorioNuevo/Fichero3.txt");
		try {
			fichero3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
