package tema06.copiar;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaCopiarArchivo2 {

  public static void main(String[] args) {

    String archivoOrigen = "./src/tema06/copiar/archivoOrigen.txt";
    String archivoDestino = "./src/tema06/copiar/archivoDestino.txt";

    File file = null;
    FileReader fr = null;
    FileWriter fw = null;

    try {
      file = new File(archivoOrigen);
      fr = new FileReader(file);
      fw = new FileWriter(archivoDestino);

      int count = 1;

      int numBytes = (int) file.length();
      System.out.println("Num bytes (org): \t" + numBytes);
      System.out.println("Num bytes (max): \t" + Integer.MAX_VALUE);

      char[] buffer = new char[numBytes];

      fr.read(buffer);
      fw.write(buffer);

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
