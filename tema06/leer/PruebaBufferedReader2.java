package tema06.leer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PruebaBufferedReader2 {

  public static void main(String[] args) {

    File file = new File("./src/tema06/numeros.txt");

    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);

      String linea;

      for (int fila = 1; (linea = br.readLine()) != null; fila++) {
        String[] numeros = linea.split(",");
        int suma = 0;

        for (String numero : numeros) {
          suma += Integer.parseInt(numero.trim());
        }

        System.out.println("La suma de la fila " + fila + " es " + suma);
      }

      br.close();
      fr.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
