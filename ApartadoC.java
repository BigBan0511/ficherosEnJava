package actividad2_3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ApartadoC {

	public static void main(String[] args) {
		File fichero = new File("FicheroAleatorio.dat");
		Scanner datos = new Scanner(System.in);
		int posicion = 0;
		long posicionEncontrada = 0;
		int contador = 0;
		char apellido[] = new char[10];
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			System.out.println("Introduzca el ID del empleado que desea modificar el salario");
			int idEmpleado = datos.nextInt();
			System.out.println("Introduzca el nuevo salario:");
			double salarioNuevo = datos.nextDouble();
			char aux;
			do {
				file.seek(posicion);
				if(posicion < file.length()) {
					if(file.readInt() == idEmpleado) {
						posicionEncontrada = file.getFilePointer();
						contador = 1;
					}else {
						posicion = posicion + 36;
					}
					if(contador == 1) {
						file.seek(file.length());
					}
				}else {
					file.seek(file.length());
				}
			} while (file.getFilePointer() != file.length());
			if(contador != 1) {
				System.out.println("El empleado con ID " + idEmpleado + " no existe");
			}else {
				file.seek((posicionEncontrada + 24));
				file.writeDouble(salarioNuevo);
				file.seek(posicionEncontrada);
				for (int x = 0; x < apellido.length; x++) {
					aux = file.readChar();
					apellido[x] = aux;
				}
				String apellidoN = new String(apellido);
				int dep = file.readInt();
				double salario = file.readDouble();
				System.out.println("Apellido: " + apellidoN + "\nSalario: " + salario);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
