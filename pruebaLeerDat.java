import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class pruebaLeerDat {

	public static void main(String[] args) {
		File fichero = new File("Empleados/empleadosNavidad.dat");
		try {
			FileInputStream input = new FileInputStream(fichero);
			ObjectInputStream objetoInput = new ObjectInputStream(input);

			Empleado emple;
			try {
			while(true) {
				emple = (Empleado) objetoInput.readObject();
				System.out.println("ID: " + emple.getId() + " \nDNI: " + emple.getDni()
									+ " \nNombre: " + emple.getNombre() + " \nApellidos : " + (emple.getApellido1() + " " + emple.getApellido2())
									+ " \nEdad: " + emple.getEdad() + " \nSexo: " + emple.getSexo() + " \nTelefono: " + emple.getTelefono()
									+ " \nSalario: " + emple.getSalario());
				System.out.println("");
			}
			}catch(EOFException e1) {
				objetoInput.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
