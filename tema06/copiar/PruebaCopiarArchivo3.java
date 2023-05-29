package tema06.copiar;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaCopiarArchivo3 {

  public static void main(String[] args) {

    String archivoOrigen = "./src/tema06/copiar/archivoOrigen.txt";
    String archivoDestino = "./src/tema06/copiar/archivoDestino.txt";

    FileReader fr = null;
    FileWriter fw = null;

    try {
      fr = new FileReader(archivoOrigen);
      fw = new FileWriter(archivoDestino);
      
      int count = 0;
     
      char[] buffer = new char[1024];
      int numCaracteres;
      while ((numCaracteres = fr.read(buffer)) != -1) {
          fw.write(buffer, 0, numCaracteres);
          count++;
      }
      
      System.out.println("El archivo se ha copiado correctamente.");
      System.out.println("Se han realizado " + count + " operaciones de escritura");
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fr != null) {
          fr.close();
        }
        if (fw != null) {
          fw.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
