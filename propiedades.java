import java.io.File;

public class propiedades {

	public static void main(String[] args) {
		
		//Acortación System.out.println() en Eclipse ---> Syso
		
		System.out.println("Informacion:");
		File f = new File("../Ficheros/src/propiedades.java");
		if(f.exists()) {
			System.out.println(f.getName());
			System.out.println(f.getPath());
			System.out.println(f.getAbsolutePath());
			System.out.println(f.canRead());
			System.out.println(f.canWrite());
			System.out.println(f.length());
		}else {
			System.out.println("El fichero no existe");
		}

	}

}
