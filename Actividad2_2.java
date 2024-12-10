package actividad2_2;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Actividad2_2 {

	public static void main(String[] args) {
		Scanner datosInt = new Scanner(System.in);
		Scanner datosString = new Scanner(System.in);
		Scanner datosChar = new Scanner(System.in);
		String opcion = "";
		Alumno al;
		File archivo = new File("alumnosActividad2_2.dat");
		try {
			FileOutputStream ficheroSalida = new FileOutputStream(archivo);
			ObjectOutputStream dataSalida = new ObjectOutputStream(ficheroSalida);
			do {
				System.out.println("Introduzca los datos del alumno:");
				System.out.println("Introduzca el nia:");
				int nia = datosInt.nextInt();
				System.out.println("Introduzca el nombre:");
				String nombre = datosString.nextLine();
				System.out.println("Introduzca los apellidos:");
				String apellidos = datosString.nextLine();
				System.out.println("Introduzca el sexo:");
				char sexo = datosChar.next().charAt(0);
				System.out.println("Introduzca el ciclo:");
				String ciclo = datosString.nextLine();
				System.out.println("Introduzca el curso:");
				String curso = datosString.nextLine();
				System.out.println("Introduzca el grupo:");
				String grupo = datosString.nextLine();
				al = new Alumno(nia, nombre, apellidos, sexo, ciclo, curso, grupo);
				dataSalida.writeObject(al);
				System.out.println("Desea continuar con mas alumnos? introduzca si o no");
				opcion = datosString.nextLine();
			} while (opcion.equalsIgnoreCase("si"));
			FileInputStream ficheroEntrada = new FileInputStream(archivo);
			ObjectInputStream dataEntrada = new ObjectInputStream(ficheroEntrada);
			try {
				while(true) {
					al = (Alumno)dataEntrada.readObject();
					System.out.println(al.getNia() + " " + al.getNombre() + " " + al.getApellidos() + " "
							+ al.getSexo() + " " + al.getCiclo() + " " + al.getCurso() + " " + al.getGrupo());
				}
			} catch (EOFException | ClassNotFoundException e) {
				dataEntrada.close();
			}
		} catch (IOException e) {
			System.out.println("El archivo no existe");
		}
	}

}
