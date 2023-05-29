package tema06.copiar;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PruebaCopiarArchivo7 {

  public static void main(String[] args) {

    String archivoOrigen = "./src/tema06/copiar/archivoOrigen.txt";
    String archivoDestino = "./src/tema06/copiar/archivoDestino.txt";

    try (Scanner scanner = new Scanner(new File(archivoOrigen)); PrintWriter writer = new PrintWriter(archivoDestino)) {

      int count = 0;

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (scanner.hasNextLine()) {
          writer.println(line);
        } else {
          writer.print(line);
        }
        count++;
      }
      System.out.println("El archivo se ha copiado correctamente.");
      System.out.println("Se han realizado " + count + " operaciones de escritura");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
