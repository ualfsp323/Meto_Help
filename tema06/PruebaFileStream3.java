package tema06;

import java.io.FileWriter;
import java.io.IOException;

public class PruebaFileStream3 {

	public static void main(String[] args) {

		try {

			FileWriter fw1 = new FileWriter("D:\\testDir\\testFile3.txt");
			FileWriter fw2 = new FileWriter("D:\testDir\testFile4.txt");
			FileWriter fw3 = new FileWriter("D:/testDir/testFile5.txt");

			fw1.write("Texto de prueba fw1");
			fw2.write("Texto de prueba fw2");
			fw3.write("Texto de prueba fw3");
			

			fw1.close();
			fw2.close();
			fw3.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
