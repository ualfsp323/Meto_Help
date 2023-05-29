package tema06.escribir;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class PruebaBufferedWriter2 {

  public static void main(String[] args) {

    File file = new File("./src/tema06/archivoPruebaBW1.txt");

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

      System.out.println("Path: " + file.getCanonicalPath());

      // Uso de append
      bw.append("Hola");

      testAppend();
      testWrite();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void testAppend() {
    
    StringWriter sw = null;
    BufferedWriter bw = null;

    CharSequence csq = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    try {
      sw = new StringWriter();

      bw = new BufferedWriter(sw);

      bw.append(csq, 5, 11);
      bw.append(" ");
      bw.append(csq, 3, 7);
      bw.append(" ");
      bw.append(csq, 2, 8);

      bw.flush();

      StringBuffer sb = sw.getBuffer();
      System.out.println(sb);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (sw != null)
        try {
          sw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      if (bw != null)
        try {
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
  }
  
  private static void testWrite() {
    
    StringWriter sw = null;
    BufferedWriter bw = null;

    CharSequence csq = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] carr = csq.toString().toCharArray();

    try {
      sw = new StringWriter();

      bw = new BufferedWriter(sw);

      bw.write(carr, 5, 6);
      bw.write(" ");
      bw.write(carr, 3, 4);
      bw.write(" ");
      bw.write(carr, 2, 6);

      bw.flush();

      StringBuffer sb = sw.getBuffer();
      System.out.println(sb);

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (sw != null)
        try {
          sw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      if (bw != null)
        try {
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
  }
  
  

}
