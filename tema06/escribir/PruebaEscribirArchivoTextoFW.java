package tema06.escribir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaEscribirArchivoTextoFW {
  
	public static void main(String[] args) throws IOException {
		
		String directorioEntrada = System.getProperty("user.dir");
		
		System.out.println("user.dir: " + directorioEntrada);

		directorioEntrada = directorioEntrada 
				+ File.separator + "src"
				+ File.separator + "tema06" 
				+ File.separator;
		
		System.out.println(directorioEntrada);
		
		String rutaArchivo = directorioEntrada
				+ "archivoPruebaEscribirArchivoTextoFW.txt";
		
		System.out.println("Ruta archivo: " + rutaArchivo);

		File file = new File(rutaArchivo);
		
		// Borrando el contenido anterior en file
		FileWriter fw = new FileWriter(file);
		
		// Añadiendo contenido a partir del contenido que hubiera en file
		//FileWriter fw = new FileWriter(file,true);
		
    for (int i = 0; i < 10; i++) {
      fw.write("Línea " + (i+1) + "\n");
    }
    
    fw.write(97);
    
    fw.close();
		
	}
}

