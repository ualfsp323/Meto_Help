package tema06.leer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PruebaBufferedReaderJava8 {

  public static void main(String[] args) {

    File file = new File("./src/tema06/archivoDatos.txt");

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      br.lines().forEach(System.out::println);
      //String cad = br.lines().collect(Collectors.joining(System.lineSeparator()));
      //System.out.println(cad);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
