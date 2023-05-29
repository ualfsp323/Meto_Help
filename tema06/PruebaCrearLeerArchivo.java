package tema06;

import java.io.File;
import java.io.IOException;

public class PruebaCrearLeerArchivo {

	public static void main(String[] args) {
		try {
			
			//File file = new File("C:\\testDir\\testFile1.txt");
			//File file = new File("D:\\testDir\\testFile9.txt");
			File file = new File("../testFile10.txt");
			//File file = new File("./archivoPrueba.txt");
			
			System.out.println("Path abs: " + file.getAbsolutePath());
			System.out.println("Path can: " + file.getCanonicalPath());
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
