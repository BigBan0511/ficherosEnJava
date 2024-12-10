import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterFichero {

	public static void main(String[] args) {
		try {
			PrintWriter fichero = new PrintWriter(new FileWriter("fichero.txt"));
			String ln;
			for (int x = 0; x < 11; x++) {
				fichero.println("Fila numero: " + x);
			}
			fichero.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
