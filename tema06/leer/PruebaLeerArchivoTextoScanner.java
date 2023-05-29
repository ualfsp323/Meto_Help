package tema06.leer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PruebaLeerArchivoTextoScanner {
  
	public static void main(String[] args) throws IOException {
		
		String directorioEntrada = System.getProperty("user.dir");
		
		System.out.println("user.dir: " + directorioEntrada);

		directorioEntrada = directorioEntrada 
				+ File.separator + "src"
				+ File.separator + "tema06" 
				+ File.separator;
		
		System.out.println(directorioEntrada);
		
		String rutaArchivo = directorioEntrada
				+ "archivoPrueba.txt";
		
		System.out.println("Ruta archivo: " + rutaArchivo);
		
		File archivo = new File(rutaArchivo);

    // Crear un objeto Scanner para leer el archivo
    Scanner scanner = new Scanner(archivo);

    // Leer cada línea del archivo y mostrarla por pantalla
    while (scanner.hasNextLine()) {
        String linea = scanner.nextLine();
        System.out.println(linea);
    }

    // cerrar el objeto Scanner
    scanner.close();
	}
}

