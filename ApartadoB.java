package actividad2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ApartadoB {

	public static void main(String[] args) {
		Scanner datosString = new Scanner(System.in);
		Scanner datosInt = new Scanner(System.in);
		Scanner datosDouble = new Scanner(System.in);
		File fichero = new File("FicheroAleatorio.dat");
		int posicion = 0;
		int posicionEncontrada;
		int contador = 0;
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			System.out.println("Introduce los datos del empleado nuevo:");
			System.out.println("ID:");
			int idDatos = datosInt.nextInt();
			do {
				if(posicion < file.length()) {
					file.seek(posicion);
					if(file.readInt() == idDatos) {
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
			if(contador == 0) {
				System.out.println("Apellidos:");
				String apellido = datosString.nextLine();
				System.out.println("Departamento:");
				int dep = datosInt.nextInt();
				System.out.println("Salario:");
				double salario = datosDouble.nextDouble();
				file.seek(file.length());
				file.writeInt(idDatos);
				file.writeChars(apellido);
				file.writeInt(dep);
				file.writeDouble(salario);
			}else {
				System.out.println("El empleado ya existe");
			}
		} catch (IOException e) {
			System.out.println("El archivo no existe");
		}

	}

}
