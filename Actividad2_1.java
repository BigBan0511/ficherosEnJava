import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Actividad2_1 {

	public static void main(String[] args) throws IOException {
		File fichero = new File("alumnos.dat");
		Scanner datosInt = new Scanner(System.in);
		Scanner datosString = new Scanner(System.in);
		Scanner datosChar = new Scanner(System.in);
		int[] nia = new int [5];
		String[] nombre = new String [5];
		String[] apellidos = new String [5];
		char[] sexo = new char [5];
		String[] ciclo = new String [5];
		String[] curso = new String [5];
		String[] grupo = new String [5];
		for (int x = 0; x < 6; x++) {
			System.out.println("Introduzca los datos del alumno " + x);
			System.out.println("Introduzca el nia:");
			nia[x] = datosInt.nextInt();
			System.out.println("Introduzca el nombre:");
			nombre[x] = datosString.nextLine();
			System.out.println("Introduzca los apellidos:");
			apellidos[x] = datosString.nextLine();
			System.out.println("Introduzca el sexo:");
			sexo[x] = datosChar.next().charAt(0);
			System.out.println("Introduzca el ciclo:");
			ciclo[x] = datosString.nextLine();
			System.out.println("Introduzca el curso:");
			curso[x] = datosString.nextLine();
			System.out.println("Introduzca el grupo:");
			grupo[x] = datosString.nextLine();
		}
		
		FileInputStream entrada;
		entrada = new FileInputStream(fichero);
		DataInputStream entradaDatos = new DataInputStream(entrada);
		int niaLeer;
		String nombreLeer;
		String apellidosLeer;
		char cicloLeer;
		String cursoLeer;
		String grupoLeer;
		try {
			while(true) {
				niaLeer = entradaDatos.read();
				nombreLeer = entradaDatos.readUTF();
				apellidosLeer = entradaDatos.readUTF();
				cicloLeer = entradaDatos.readChar();
				cursoLeer = entradaDatos.readUTF();
				grupoLeer = entradaDatos.readUTF();
				System.out.println("NIA: " + niaLeer +
						"\n Nombre: " + nombreLeer +
						"\n Apellidos: " + apellidosLeer +
						"\n Ciclo: " + cicloLeer +
						"\n Curso: " + cursoLeer +
						"\n Grupo: " + grupoLeer);
			}
		}catch(EOFException i) {
			entradaDatos.close();
		}
		
	}

}
