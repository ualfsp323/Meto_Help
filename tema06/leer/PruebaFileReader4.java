package tema06.leer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PruebaFileReader4 {

  public static void main(String[] args) {

    File file = new File("./src/tema06/archivoPrueba.txt");

    int ini = 8;
    int fin = 14;

    String result = "";

    try (FileReader fr = new FileReader(file)) {

      int index = ini;
      int content;
      int i = 0;

      while ((content = fr.read()) != -1 && index <= fin) {

        if (i == index) {
          result += (char) content;
          index++;
        }
        i++;

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Resultado-->" + result + "<--");
  }


}
