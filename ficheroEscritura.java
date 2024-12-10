import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ficheroEscritura {

	public static void main(String[] args) {
		File ficherin = new File("FicheroEscritura.txt");
		try {
			FileWriter fich = new FileWriter(ficherin);
			String str = "Aupa atleti";
			char[] cad = str.toCharArray();
			for (int i = 0; i < cad.length; i++) {
				fich.write(cad[i]);
				fich.append('-');
			}
			fich.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
