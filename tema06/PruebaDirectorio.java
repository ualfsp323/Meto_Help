package tema06;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class PruebaDirectorio {

  public static void main(String[] args) {

    File dir = new File("C:\\testDir");

    String[] resultList = dir.list();
    System.out.println("dir.list() --> " + Arrays.toString(resultList));

    // Filtro para seleccionar ciertos archivos (FilenameFilter)
    FilenameFilter filterFNF = new FilenameFilter() {
      public boolean accept(File dir, String name) {
        // return name.endsWith(".txt");
        return name.contains("fold");
      }
    };

    // Filtro para seleccionar ciertos archivos (FileFilter)
    FileFilter filterFF = new FileFilter() {
      public boolean accept(File file) {
        // return file.isFile() && file.getName().endsWith(".txt");
        return file.isFile() && file.getName().contains("fold");
      }
    };

    String[] resultListFNF = dir.list(filterFNF);
    System.out.println("dir.list(FilenameFilter) --> " + Arrays.toString(resultListFNF));

    File[] resultListFilesFNF = dir.listFiles(filterFNF);
    System.out.println("dir.listFiles(FilenameFilter) --> " + Arrays.toString(resultListFilesFNF));

    File[] resultListFilesFF = dir.listFiles(filterFF);
    System.out.println("dir.listFiles(FileFilter) --> " + Arrays.toString(resultListFilesFF));

    File[] resultListFiles = dir.listFiles();
    System.out.println("dir.listFiles() --> " + Arrays.toString(resultListFiles));

    File[] resultListRoots = File.listRoots();
    System.out.println("dir.listRoots() --> " + Arrays.toString(resultListRoots));

    // ¿Cuáles son archivos y cuáles son directorios?
    File[] contents = dir.listFiles();
    for (int i = 0; i < contents.length; i++) {
      File element = contents[i];
      if (element.isFile()) {
        System.out.println(element.getName() + " es un archivo.");
      } else if (element.isDirectory()) {
        System.out.println(element.getName() + " es un directorio.");
      }
    }

  }

}
