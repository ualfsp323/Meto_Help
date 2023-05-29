package tema06.escribir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PruebaFileWriter1 {

  public static void main(String[] args) {

    File file = new File("./src/tema06/archivoPruebaFW1.txt");    

    FileWriter fw = null;

    try {
      
      System.out.println("Path: " + file.getCanonicalPath());

      fw = new FileWriter(file);
      
      fw.write('H');
      fw.write('o');
      fw.write('l');
      fw.write('a');
      fw.write(10);
      
      fw.write("Adiós");
      fw.write("¿Líneas?");
      
      String mensaje = "Hola, me llamo Javi.";
      fw.write(mensaje, 6, 13);
      
      char[] caracteresCadena = {'C', 'a', 'd', 'e', 'n', 'a'};
      fw.write(caracteresCadena);
      
      char[] caracteres = {'E', 's', 't', 'e', ' ', 'e', 's', ' ', 'u', 'n', ' ', 'e', 'j', 'e', 'm', 'p', 'l', 'o'};
      fw.write(caracteres, 5, 13);
      
      String nombre = "Javi";
      double altura = 1.82;
      fw.write(String.format("Hola, mi nombre es %s y mido %.2f metros.", nombre, altura));
      
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

      if (fw != null) {
        try {
          fw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

    }

  }

}
