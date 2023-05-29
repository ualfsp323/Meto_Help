package tema06.leer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class PruebaLeerCabecera {

  public static void main(String[] args) {

    String directorioEntrada = System.getProperty("user.dir");
    directorioEntrada = directorioEntrada + File.separator + "src" + File.separator + "tema06" + File.separator;
    String rutaArchivo = directorioEntrada + "archivoDatos.txt";
    System.out.println("Ruta archivo: " + rutaArchivo);
    
    File file = new File(rutaArchivo);
    
    ArrayList<String> cabecera = leerCabecera(file);
    System.out.println("Cabecera del archivo: " + cabecera);
    System.out.println("Número de columnas: " + cabecera.size());
    
  }
  
  private static ArrayList<String> leerCabecera(File file)  {
    
    ArrayList<String> cabecera = new ArrayList<String>();

    FileReader fr = null;
    BufferedReader br = null;
    
    try {
      fr = new FileReader(file);
      br = new BufferedReader(fr);

      String linea = br.readLine();
      
      if(linea != null) {       
        
        System.out.println("Línea cabecera: " + linea);
        
        String separador = ";";
        //https://www.oracle.com/java/technologies/javase/java8locales.html
        Locale localizacion = new Locale("es", "ES");
        
        Scanner scanner = new Scanner(linea);
        scanner.useDelimiter(separador);
        scanner.useLocale(localizacion);
        
        while (scanner.hasNext()) {
          String columna = scanner.next();
          cabecera.add(columna);
        }
        
        scanner.close();        
      }
    } catch (IOException e) {
      System.out.println("Error al leer el archivo: " + file);
      e.printStackTrace();
    } finally {
      try {
        if (br != null) {
          br.close();
        }
        if (fr != null) {
          fr.close();
        }
      } catch (IOException e) {        
        System.out.println("Error al cerrar el archivo: " + file);
        e.printStackTrace();
      }
    }
    
    return cabecera;
  }
}
