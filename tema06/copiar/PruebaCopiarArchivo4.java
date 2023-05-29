package tema06.copiar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaCopiarArchivo4 {

  public static void main(String[] args) {

    String archivoOrigen = "./src/tema06/copiar/archivoOrigen.txt";
    String archivoDestino = "./src/tema06/copiar/archivoDestino.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(archivoOrigen));
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoDestino))) {

      String line;
      int count = 0;

      while ((line = br.readLine()) != null) {
        bw.write(line);
        bw.newLine();
        count++;
      }
      System.out.println("El archivo se ha copiado correctamente.");
      System.out.println("Se han realizado " + count + " operaciones de escritura");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
