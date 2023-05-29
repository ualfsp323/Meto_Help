package tema06.leer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PruebaScanner1 {

  public static void main(String[] args) {

    File file = new File("./src/tema06/archivoDatos.txt");

    Scanner scanner;
    try {
      
      scanner = new Scanner(file);
      
      while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
      }
      
      scanner.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

}
