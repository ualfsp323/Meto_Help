package tema06.leer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PruebaBufferedReader1 {

  public static void main(String[] args) {

    File file = new File("./src/tema06/archivoDatos.txt");

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      
      String line;
      
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
