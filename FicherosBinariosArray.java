import java.io.*;

public class FicherosBinariosArray {

	public static void main(String[] args) throws IOException {
		File fichero = new File("FicherosArrays.dat");
		FileOutputStream salida = new FileOutputStream(fichero);
		DataOutputStream salidaDatos = new DataOutputStream(salida);
		String marcas[] = {"Marca1","Marca2","Marca3","Marca4","Marca5","Marca6","Marca7","Marca8","Marca9","Marca10"};
		int anios[] = {2,4,6,2,4,8,3,9,1,3};
		for (int x = 0; x < anios.length; x++) {
			salidaDatos.writeUTF(marcas[x]);
			salidaDatos.writeInt(anios[x]);
		}
		salidaDatos.close();
		salida.close();
		
		FileInputStream entrada = new FileInputStream(fichero);
		DataInputStream entradaDatos = new DataInputStream(entrada);
		int x;
		String a;
		try {
			while(true) {
				//Tiene que leer y mostrar en el mismo orden
				a = entradaDatos.readUTF();
				x = entradaDatos.readInt();
				System.out.println(a + " " + x);
			}
		}catch(EOFException e) {
			entradaDatos.close();
		}
		
	}

}
