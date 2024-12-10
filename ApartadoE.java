package actividad2_3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ApartadoE {

	public static void main(String[] args) {
		File fichero = new File("FicheroAleatorio.dat");
		ArrayList<Long> posEncontradas = new ArrayList<>();
		int pos = 0;
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "r");
			do {
				file.seek(pos);
				if(file.getFilePointer() < file.length()) {
					if(file.readInt() == -1) {
						posEncontradas.add(file.getFilePointer());
					}else {
						pos = pos + 36;
					}
				}else {
					file.seek(file.length());
				}
			} while (file.getFilePointer() != file.length());
			System.out.println("ESTOS EMPLEADOS HAN SIDO BORRADOS:");
			for(Long actual : posEncontradas) {
				file.seek((actual - 36));
				int id = file.readInt();
				char apellido[] = new char[10], aux;
				for (int x = 0; x < apellido.length; x++) {
					aux = file.readChar();
					apellido[x] = aux;
				}
				String apellidoCompleto = new String(apellido);
				System.out.println("Id: " + id
						+ "\nApellido: " + apellidoCompleto);
			}
			file.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero");
		}

	}

}
