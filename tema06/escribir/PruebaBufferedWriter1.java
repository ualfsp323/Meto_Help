package tema06.escribir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaBufferedWriter1 {

  public static void main(String[] args) {

    File file = new File("./src/tema06/archivoPruebaBW1.txt");

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

      System.out.println("Path: " + file.getCanonicalPath());

      // Escritura 1
      String texto = "Este es un mensaje de ejemplo.";
      bw.write(texto);

      // Escritura 2
      for (int i = 1; i <= 10; i++) {
        String linea = "Línea " + i;
        bw.write(linea);
        bw.newLine();
      }

      // Escritura 3
      String[] textoArray = { "Este es el primer elemento", "Este es el segundo", "Y este el tercero" };
      for (String linea : textoArray) {
        bw.write(linea);
        bw.newLine();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
