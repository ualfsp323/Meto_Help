package tema06;
import java.io.File;

public class PruebaArchivos {

	public static void main(String[] args) {
	  
	  System.out.println("File.separator: " + File.separator);
	  System.out.println("file.separator: " + System.getProperty("file.separator"));

		String directorioEntrada = System.getProperty("user.dir");

		System.out.println("user.dir: " + directorioEntrada);

		directorioEntrada = directorioEntrada
		    + File.separator + "src"
				+ File.separator + "tema06"
				+ File.separator;

		System.out.println(directorioEntrada);

		String archivoDondeEsta = directorioEntrada
				+  "archivoPrueba.txt";

		System.out.println(archivoDondeEsta);

		File file = new File(archivoDondeEsta);

		System.out.println("Nombre: "+ file.getName());

		System.out.println("Tamaño (bytes): "+ file.length());
		
		System.out.println("Tamaño de la partición (bytes): "+ file.getTotalSpace());
		System.out.println("Espacio libre de la partición (bytes): "+ file.getFreeSpace());
		
	}
}


