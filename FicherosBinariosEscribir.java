import java.io.*;

public class FicherosBinariosEscribir {

	public static void main(String[] args) {
		File fichero = new File("FicheroPrueba.dat");
		try {
			FileOutputStream salida = new FileOutputStream(fichero, true);
			FileInputStream entrada = new FileInputStream(fichero);
			int i;
			for ( i = 0; i < 101; i++) {
				salida.write(i);
			}
			salida.close();
			while((i=entrada.read())!=-1) {
				System.out.println(i);
			}
			entrada.close();
		} catch (IOException e) {
			System.out.println("El archivo no existe");
		}
		

	}

}
