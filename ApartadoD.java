package actividad2_3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ApartadoD {

	public static void main(String[] args) {
		File fichero = new File("FicheroAleatorio.dat");
		Scanner datos = new Scanner(System.in);
		int contador = 0;
		int posicion = 0;
		long posEncontrada = 0;
		try {
			RandomAccessFile random = new RandomAccessFile(fichero, "rw");
			System.out.println("Introduzca el id del empleado a borrar");
			int idElegido = datos.nextInt();
			do {
				random.seek(posicion);
				if(random.getFilePointer() < random.length()) {
					if(random.readInt() == idElegido) {
						contador = 1;
						posEncontrada = random.getFilePointer();
					}else {
						posicion = posicion + 36;
					}
					if(contador == 1) {
						random.seek(random.length());
					}
				}else {
					random.seek(random.length());
				}
			} while (random.length() != random.getFilePointer());
			if(contador != 1) {
				System.out.println("El empleado no existe");
			}else {
				random.seek((posEncontrada - 1));
				random.writeInt(-1);
			}
			random.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
		}

	}

}
