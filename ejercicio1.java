import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		Scanner datos = new Scanner(System.in);
		try {
			BufferedWriter fich = new BufferedWriter(new FileWriter("escribeCaracteres.txt"));
			int num = 1;
			for (int i = 0; i < 11; i++) {
				System.out.println("Escriba un caracter");
				String caracter = datos.next();
				fich.write(num);
				fich.write(caracter);
				fich.newLine();
				num++;
			}
			fich.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
