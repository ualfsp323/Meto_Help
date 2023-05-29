package tema06.leer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PruebaLeerDatos {

  public static void main(String[] args) {

    String directorioEntrada = System.getProperty("user.dir");
    directorioEntrada = directorioEntrada + File.separator + "src" + File.separator + "tema06" + File.separator;
    String rutaArchivo = directorioEntrada + "archivoDatos.txt";
    System.out.println("Ruta archivo: " + rutaArchivo);

    File file = new File(rutaArchivo);

    int filas = contarLineas(file);
    System.out.println("Número de filas: " + filas);

    int columnas = contarColumnas(file);
    System.out.println("Número de columnas: " + columnas);

    String[][] datos = leerDatos(file, filas, columnas);
    System.out.println("Archivo datos: ");
    for (int i = 0; i < filas; i++) {
      System.out.println(Arrays.toString(datos[i]));
    }

  }

  private static int contarLineas(File file) {

    int lineas = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

      while ((br.readLine()) != null) {
        lineas += 1;
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Sin contar la cabecera
    return lineas - 1;
  }

  private static int contarColumnas(File file) {

    int columnas = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

      String linea = br.readLine();

      Scanner scanner = new Scanner(linea);
      scanner.useDelimiter(";");

      while (scanner.hasNext()) {
        scanner.next();
        columnas++;
      }

      scanner.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return columnas;
  }

  private static String[][] leerDatos(File file, int filas, int columnas) {

    String[][] datos = new String[filas][columnas];

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

      String cabecera = br.readLine();
      System.out.println("Cabecera: " + cabecera);

      for (int i = 0; i < filas; i++) {
        String linea = br.readLine();

        Scanner scanner = new Scanner(linea);
        scanner.useDelimiter(";");

        for (int j = 0; j < columnas; j++) {
          String dato = scanner.next();
          datos[i][j] = dato;
        }

        scanner.close();
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return datos;
  }
}
