import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class escribirFicheroObjeto {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Persona persona;
		File fichero = new File("FicheroPersona.dat");
		FileOutputStream ficheroSalida = new FileOutputStream(fichero);
		ObjectOutputStream dataSalida = new ObjectOutputStream(ficheroSalida);
		String nombre[] = {"Manuel","Lamine","Daniel","Juan","Pedro","Marcos","Adrian","Edelberto","Anastasia","Dolores"};
		int edad[] = {2,4,6,2,4,8,3,9,1,3};
		for (int x = 0; x < edad.length; x++) {
			persona = new Persona(nombre[x], edad[x]);
			dataSalida.writeObject(persona);
		}
		dataSalida.close();
		
		FileInputStream ficheroEntrada = new FileInputStream(fichero);
		ObjectInputStream dataEntrada = new ObjectInputStream(ficheroEntrada);
		try {
			while (true) {
				persona = (Persona)dataEntrada.readObject();
				System.out.println(persona.getNombre() + "  " + persona.getEdad());
			}
		} catch (EOFException e) {
			dataEntrada.close();
		}

	}

}
