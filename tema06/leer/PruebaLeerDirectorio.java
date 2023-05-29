package tema06.leer;

import java.io.File;

public class PruebaLeerDirectorio {

	public static void main(String[] args) {

		File dir = new File("C:\\testDir");
		listarArchivos(dir,0);

	}

	public static void listarArchivos(File directorio, int nivel) {
		
		String tabs = "";
		for(int i=0; i<nivel; i++) {
			tabs+="\t";
		}
		
		File[] archivos = directorio.listFiles();
		
		if (archivos != null) {
			
			for (File archivo : archivos) {
				if (archivo.isDirectory()) {
					System.out.println(tabs + "Directorio: " + archivo.getAbsolutePath());
					listarArchivos(archivo,nivel+1);
				} else {
					System.out.println(tabs + "Archivo: " + archivo.getAbsolutePath());
				}
			}
			
//			for (int i=0; i<archivos.length; i++) {
//				File archivo = archivos[i];
//				if (archivo.isDirectory()) {
//					System.out.println(tabs + "Directorio: " + archivo.getAbsolutePath());
//					listarArchivos(archivo,nivel+1);
//				} else {
//					System.out.println(tabs + "Archivo: " + archivo.getAbsolutePath());
//				}
//			}
		}
	}

}
