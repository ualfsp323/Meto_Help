package tema06.escribir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConjuntoDatosTexto {

  private File archivo;
  private String separador;
  private Locale locale;

  private List<String> cabecera;
  private int numeroColumnas;
  private int numeroFilas;

  String[][] datos;

  public ConjuntoDatosTexto(String rutaArchivo) {

    archivo = new File(rutaArchivo);
    numeroFilas = this.contarFilas(archivo);
    numeroColumnas = this.contarColumnas(archivo);
    cabecera = this.leerCabecera(archivo);
    datos = this.leerDatos(archivo, numeroFilas, numeroColumnas);
  }

  private ArrayList<String> leerCabecera(File file) {

    ArrayList<String> cabecera = new ArrayList<String>();

    FileReader fr = null;
    BufferedReader br = null;

    try {
      fr = new FileReader(file);
      br = new BufferedReader(fr);

      String linea = br.readLine();

      if (linea != null) {

        // System.out.println("Línea cabecera: " + linea);

        String separador = ";";
        // https://www.oracle.com/java/technologies/javase/java8locales.html
        Locale localizacion = new Locale("es", "ES");

        Scanner scanner = new Scanner(linea);
        scanner.useDelimiter(separador);
        scanner.useLocale(localizacion);

        while (scanner.hasNext()) {
          String columna = scanner.next();
          cabecera.add(columna);
        }

        scanner.close();
      }
    } catch (IOException e) {
      System.out.println("Error al leer el archivo: " + file);
      e.printStackTrace();
    } finally {
      try {
        if (br != null) {
          br.close();
        }
        if (fr != null) {
          fr.close();
        }
      } catch (IOException e) {
        System.out.println("Error al cerrar el archivo: " + file);
        e.printStackTrace();
      }
    }

    return cabecera;
  }

  private int contarFilas(File file) {

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

  private int contarColumnas(File file) {

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

  private String[][] leerDatos(File file, int filas, int columnas) {

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

  @Override
  public String toString() {

    String resultado = "";

    resultado += "La cabecera es: " + this.getCabecera().toString() + "\n";
    resultado += "Los datos son:\n";

    for (int i = 0; i < this.getNumeroFilas(); i++) {
      resultado += Arrays.toString(datos[i]) + "\n";
    }

    return resultado;

  }

  public String[] getDatosColumna(int numColumna) {

    if (numColumna < 0 || numColumna > this.getNumeroColumnas()) {
      System.out.println("Número de columna no válida");
      return null;
    }

    String[] datosColumna = new String[this.getNumeroFilas()];

    for (int i = 0; i < this.getNumeroFilas(); i++) {
      datosColumna[i] = datos[i][numColumna];
    }

    return datosColumna;
  }

  public void exportarDatosColumna(String columna) {

    int indice = -1;

    boolean encontrado = false;

    for (int i = 0; i < cabecera.size() && encontrado == false; i++) {
      String col = cabecera.get(i);
      if (col.equals(columna)) {
        indice = i;
        encontrado = true;
      }
    }

    if (encontrado) {
      String[] datosColumna = getDatosColumna(indice);
      // System.out.println(Arrays.toString(datosColumna));
      
      System.out.println(datosColumna.length);
      System.out.println(this.numeroFilas);

      File file = new File("./src/tema06/escribir/columna" + columna + ".txt");
      try (PrintWriter pw = new PrintWriter(file)) {

        for (int j = 0; j < datosColumna.length - 1; j++) {
          // System.out.println();
          pw.print(datosColumna[j]);
          pw.print(";");
        }
        pw.print(datosColumna[datosColumna.length - 1]);

      } catch (IOException e) {
        e.printStackTrace();
      }

    } else {
      System.out.println("No se ha encontrado la columna con ese nombre.");
    }

  }

  public void exportar(String[] cabecera, String archivoDestino, String separador) {

    File file = new File("./src/tema06/escribir/" + archivoDestino);

    try (PrintWriter pw = new PrintWriter(file)) {

      for (int i = 0; i < cabecera.length; i++) {
        pw.print(cabecera[i]);
        if ((i < cabecera.length - 1)) {
          pw.print(separador);
        }
      }
      pw.println();

      for (int i = 0; i < datos.length; i++) {
        for (int j = 0; j < datos[i].length; j++) {
          pw.print(datos[i][j]);
          if ((j < datos[i].length - 1)) {
            pw.print(separador);
          }
        }
        pw.println();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  // Getters and setters
  public File getArchivo() {
    return archivo;
  }

  public void setArchivo(File archivo) {
    this.archivo = archivo;
  }

  public String getSeparador() {
    return separador;
  }

  public void setSeparador(String separador) {
    this.separador = separador;
  }

  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public List<String> getCabecera() {
    return cabecera;
  }

  public void setCabecera(List<String> cabecera) {
    this.cabecera = cabecera;
  }

  public int getNumeroColumnas() {
    return numeroColumnas;
  }

  public void setNumeroColumnas(int numeroColumnas) {
    this.numeroColumnas = numeroColumnas;
  }

  public int getNumeroFilas() {
    return numeroFilas;
  }

  public void setNumeroFilas(int numeroFilas) {
    this.numeroFilas = numeroFilas;
  }

  public String[][] getDatos() {
    return datos;
  }

  public void setDatos(String[][] datos) {
    this.datos = datos;
  }

}
