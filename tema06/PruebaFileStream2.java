package tema06;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaFileStream2 {

	public static void main(String[] args) {

		try {

			FileWriter fw = new FileWriter("D:\\testDir\\testFile2.txt");
			FileReader fr = new FileReader("D:\\testDir\\testFile2.txt");

			fw.write("Texto de prueba");
			fw.write(13);
			fw.write(72);
			fw.write(111);
			fw.write(108);
			fw.write(97);
			fw.write(13);
			fw.write("Otro texto de prueba");
			
			fw.flush();

			int valor = fr.read();
			while (valor != -1) {
				System.out.print((char) valor);
				valor = fr.read();
			}

			fw.close();
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
