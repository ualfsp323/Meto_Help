package tema06.leer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PruebaFileReader3 {

  public static void main(String[] args) throws IOException {

    File file = new File("./src/tema06/archivoPrueba.txt");
    
    int ini = 9;
    int fin = 16;
    
    int numChars = countChars(file);

    try (FileReader fr = new FileReader(file)) {
      
      char[] chars = new char[numChars];
      //char[] chars = new char[fin-ini]; 

      //fr.read(chars);
      int result = fr.read(chars, ini, (fin-ini));
      System.out.println("Leídos: " + result);

      String fileContent = new String(chars);
      System.out.println(fileContent);
      
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  
  private static int countChars(File f) {
    
    int count = 0;
    
    try (FileReader fr = new FileReader(f)) {
      int charRead = fr.read();
      while (charRead != -1) {
          count++;
          charRead = fr.read();
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return count;
    
  }

}
