package actividad2_3;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ApartadoA {

	public static void main(String[] args) {
		File fichero = new File("FicheroAleatorio.dat");
		Scanner datos = new Scanner(System.in);
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "r");
			System.out.println("Introduce el ID del empleado:");
			int id = datos.nextInt();
			int contador = 0;
			int posicion = 0;
			long posicionEncontrada = 0;
			int idDatos, dep;
			double salario;
			char apellido[] = new char[10];
			char aux;
			do {
				if(posicion < file.length()) {
					file.seek(posicion);
					if(file.readInt() == id) {
						contador = 1;
						posicionEncontrada = posicion;
					}
					if(contador == 1) {
						file.seek(file.length());
					}
					posicion = posicion + 36;
				}else {
					file.seek(file.length());
				}
			} while (file.getFilePointer() != file.length());
			if(contador == 1) {
				file.seek(posicionEncontrada);
				idDatos = file.readInt();
				for (int x = 0; x < apellido.length; x++) {
					aux = file.readChar();
					apellido[x] = aux;
				}
				String apellidoN = new String(apellido);
				dep = file.readInt();
				salario = file.readDouble();
				System.out.println("Id: " + idDatos
						+ "\nApellido: " + apellidoN
						+ "\nDepartamento: " + dep
						+ "\nSalario: " + salario);
			}else {
				System.out.println("El empleado con el ID " + id + " no existe");
			}
			file.close();
		} catch (IOException e) {
			System.out.println("Este archivo no existe");
			e.printStackTrace();
		}

	}

}
