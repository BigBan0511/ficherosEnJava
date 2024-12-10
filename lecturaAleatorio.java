import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class lecturaAleatorio {

	public static void main(String[] args) {
		File fich = new File("FicheroAleatorio.dat");
		try {
			RandomAccessFile file = new RandomAccessFile(fich, "r");
			int id, dep, pos;
			double salario;
			char apellido[] = new char[10], aux;
			pos = 0;
			for(;;) {
				if(file.getFilePointer() == file.length() || pos > file.length()) {
					break;
				}else {
					file.seek(pos);
					id = file.readInt();
					for (int x = 0; x < apellido.length; x++) {
						aux = file.readChar();
						apellido[x] = aux;
					}
					String apellidoX = new String(apellido);
					dep = file.readInt();
					salario = file.readDouble();
					System.out.println("Id: " + id
							+ "\nApellido: " + apellidoX
							+ "\nDepartamento: " + dep
							+ "\nSalario: " + salario);
				}
				pos = pos + 36;
			}
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
