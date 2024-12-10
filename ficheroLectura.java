import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ficheroLectura {

	public static void main(String[] args) {
		File fichero = new File("src/ficheroLectura.java");
		try {
			FileReader fich = new FileReader(fichero);
			int i;
			try {
				while ((i = fich.read())!=-1)
					System.out.print((char)i);
				fich.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
