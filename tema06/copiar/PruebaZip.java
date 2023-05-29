package tema06.copiar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PruebaZip {

  public static void main(String[] args) {

    File dir = new File("./src/tema06/copiar/");
    String caminoSalida = ".";
    String nombreArchivo = "comprimidoBinarioOK.zip";

    zip(dir, caminoSalida, nombreArchivo);

  }

  public static void zip(File dir, String caminoSalida, String nombreArchivo) {

    String outputFilePath = caminoSalida + File.separator + nombreArchivo;

    try {

      String inputFolderPath = dir.getCanonicalPath();

      System.out.println("Input folder: " + inputFolderPath);
      System.out.println("Output file: " + outputFilePath);

      ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputFilePath));
      addFolderToZip("", inputFolderPath, zos);

      zos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void addFolderToZip(String parentPath, String folderPath, ZipOutputStream zipOutputStream) {

    File folder = new File(folderPath);

    // Obtener archivos y directorios dentro del directorio
    File[] files = folder.listFiles();

    // Recorrer archivos y directorios
    for (File file : files) {
      if (file.isDirectory()) {
        // Si es un directorio, agregarlo al zip y llamar recursivamente a esta función
        addFolderToZip(parentPath + file.getName() + "/", file.getAbsolutePath(), zipOutputStream);
      } else {
        // Si es un archivo, agregarlo al archivo zip mediante una nueva función
        addFileToZip(parentPath, file.getAbsolutePath(), zipOutputStream);
      }
    }
  }
  
  public static void addTextFileToZip(String parentPath, String filePath, ZipOutputStream zos) {

    File file = new File(filePath);

    // Crear objeto ZipEntry para el archivo
    ZipEntry zipEntry = new ZipEntry(parentPath + file.getName());

    try {
      // Agregar el objeto ZipEntry al archivo zip
      zos.putNextEntry(zipEntry);

      // Leer y escribir el contenido del archivo en el archivo zip     
      FileReader fr = new FileReader(file);
      int c;
      while ((c = fr.read()) != -1) {
        zos.write(c);
      }
      fr.close();
      
      
      zos.closeEntry();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }



  public static void addFileToZip(String parentPath, String filePath, ZipOutputStream zos) {

    File file = new File(filePath);

    // Crear objeto ZipEntry para el archivo
    ZipEntry zipEntry = new ZipEntry(parentPath + file.getName());

    try {
      // Agregar el objeto ZipEntry al archivo zip
      zos.putNextEntry(zipEntry);

      // Crear objeto FileInputStream para el archivo
      FileInputStream fis = new FileInputStream(file);

      // Leer y escribir el contenido del archivo en el archivo zip
      byte[] buffer = new byte[1024];
      int length;
      while ((length = fis.read(buffer)) > 0) {
        zos.write(buffer, 0, length);
      }
      fis.close();     
      
      zos.closeEntry();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
