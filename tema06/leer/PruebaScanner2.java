package tema06.leer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PruebaScanner2 {

  public static void main(String[] args) {

    File file = new File("./src/tema06/numeros.txt");

    try {
      Scanner scanner = new Scanner(file);

      for (int fila = 1; scanner.hasNextLine(); fila++) {
        int suma = 0;
        Scanner lineaScanner = new Scanner(scanner.nextLine());
        lineaScanner.useDelimiter(",");

        while (lineaScanner.hasNextInt()) {
          suma += lineaScanner.nextInt();
        }

        System.out.println("La suma de la fila " + fila + " es " + suma);

      }
      
      scanner.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

}
