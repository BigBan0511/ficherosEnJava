import java.io.*;

public class listaDirectorio {

	public static void main(String[] args) {
		File f = new File (".");
		String[] files = f.list();
		for(int x=0; x<files.length; x++) {
			System.out.println(files[x]);
		}
		

	}

}
