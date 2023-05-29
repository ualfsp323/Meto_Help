package tema06;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaFileStream1 {

	public static void main(String[] args) {

		try {

			FileWriter fw = new FileWriter("C:\\testDir\\testFile1.txt");
			FileReader fr = new FileReader("C:\\testDir\\testFile1.txt");

			fw.write("Texto de prueba");
			fw.write(13);
			fw.write(72);
			fw.write(111);
			fw.write(108);
			fw.write(97);
			fw.write(13);
			fw.write("Otro texto de prueba");

			
			fw.close();
			
			int valor = fr.read();
			while (valor != -1) {
				System.out.print((char) valor);
				valor = fr.read();
			}

			
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
