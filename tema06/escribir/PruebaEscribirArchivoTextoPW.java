package tema06.escribir;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class PruebaEscribirArchivoTextoPW {
  
	public static void main(String[] args) throws IOException {
		
		String directorioEntrada = System.getProperty("user.dir");
		
		System.out.println("user.dir: " + directorioEntrada);

		directorioEntrada = directorioEntrada 
				+ File.separator + "src"
				+ File.separator + "tema06" 
				+ File.separator;
		
		System.out.println(directorioEntrada);
		
		String rutaArchivo = directorioEntrada
				+ "archivoPruebaEscribirArchivoTextoPW.txt";
		
		System.out.println("Ruta archivo: " + rutaArchivo);

		File file = new File(rutaArchivo);
		
		// Borrando el contenido anterior en file
		PrintWriter pw = new PrintWriter(file);
		
		// Añadiendo contenido a partir del contenido que hubiera en file
		//FileWriter fw = new FileWriter(file,true);
		//PrintWriter pw = new PrintWriter(fw);
		
    for (int i = 0; i < 10; i++) {
      pw.write("Línea " + (i+1) + "\n");
    }
    
    //pw.write(97);
    pw.println(97);
    
    pw.close();
		
	}
}

