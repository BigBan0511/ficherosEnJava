import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class escribirFicheroAleatorio {

	public static void main(String[] args) throws IOException {
		File fichero = new File("FicheroAleatorio.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		String apellido[] = {"Garcia","Gonzalez","Herrero","Ronaldo","Alonso"};
		int codDepartamento[] = {10,20,10,30,40};
		Double salario[] = {1000.50,2400.50,100.10,900000.77,10000.33};
		StringBuffer buffer = null;
		int n = apellido.length;
		for (int x = 0; x < n; x++) {
			file.writeInt(x + 1);
			buffer = new StringBuffer(apellido[x]);
			buffer.setLength(10);//Reservar 10 caracteres para el apellido
			file.writeChars(buffer.toString());//Escribir el apellido
			file.writeInt(codDepartamento[x]);
			file.writeDouble(salario[x]);
		}
		file.close();

	}

}
