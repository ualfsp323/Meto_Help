package tema06.escribir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaBufferedWriter3 {

  public static void main(String[] args) {

    File file = new File("./src/tema06/archivoPruebaBW1.txt");

    try {

      System.out.println("Path: " + file.getCanonicalPath());

      FileWriter fw = new FileWriter(file, true);
      BufferedWriter bw = new BufferedWriter(fw);

      bw.write("Esta es una línea nueva.\n");

      bw.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
