import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class lecturaFicheroBuffer {

	public static void main(String[] args) {
		try {
			BufferedReader fichero = new BufferedReader(new FileReader("src/lecturaFicheroBuffer.java"));
			String linea;
			try {
				while((linea=fichero.readLine())!=null) {
					System.out.println(linea);
					
				}
				fichero.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
