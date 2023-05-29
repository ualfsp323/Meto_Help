package tema06.leer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PruebaFileReader1 {

  public static void main(String[] args) throws IOException {

    File file = new File("./src/tema06/archivoPrueba.txt");
    System.out.println("Path: " + file.getCanonicalPath());

    FileReader fr = null;

    try {

      fr = new FileReader(file);

      int content;
      int index = 0;
      while ((content = fr.read()) != -1) {

        //System.out.print((char) content);

        // System.out.println((char) content);
        // System.out.println(content);

        System.out.println((char) content + "(" + content + ")" + " - [" + index + "]");
        index++;

      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

      if (fr != null) {
        try {
          fr.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }

  }

}
