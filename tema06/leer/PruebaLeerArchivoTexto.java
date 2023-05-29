package tema06.leer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PruebaLeerArchivoTexto {
  
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
		
		// Opción 1
		File file = new File(rutaArchivo);		
		FileReader fr = new FileReader(file);		
		BufferedReader br = new BufferedReader(fr);
		
		// Opción 2		
		//FileReader fr = new FileReader(rutaArchivo);
    //BufferedReader br = new BufferedReader(fr);
    
		// Opción 3
		//BufferedReader br = new BufferedReader(new FileReader(new File(rutaArchivo)));
		
		// Opción 4
		//BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
		
		String linea;
		// Lee archivo línea a línea
		while ((linea = br.readLine()) != null) {			
			System.out.println(linea);
		}
		// Cierra el archivo (cierra también el FileReader)
		br.close();
	}
}

