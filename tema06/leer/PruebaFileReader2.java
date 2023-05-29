package tema06.leer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PruebaFileReader2 {

  public static void main(String[] args) throws IOException {

    File file = new File("./src/tema06/archivoPrueba.txt");
    System.out.println("Path: " + file.getCanonicalPath());
    
    int numChars = countChars(file);

    // try-with-resources (desde Java 7)
    // https://www.baeldung.com/java-try-with-resources
    // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
    try (FileReader fr = new FileReader(file)) {
      
      System.out.println("Num chars: " + numChars);
      System.out.println("File length: " + file.length());
      
      char[] chars = new char[(int) file.length()];    
      //char[] chars = new char[numChars];
      //char[] chars = new char[1024];  
      //char[] chars = new char[(int) file.length()-3];
      //char[] chars = new char[(int) file.length()-7];
      
      fr.read(chars);

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
