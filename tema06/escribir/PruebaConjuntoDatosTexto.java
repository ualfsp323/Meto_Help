package tema06.escribir;

public class PruebaConjuntoDatosTexto {

  public static void main(String[] args) {

    String rutaArchivo = "./src/tema06/escribir/archivoDatos.txt";
    ConjuntoDatosTexto cdt = new ConjuntoDatosTexto(rutaArchivo);
    System.out.println(cdt);
    
    //cdt.getDatosColumna(50);
    
    cdt.exportarDatosColumna("Edad");
    
    String[] cabecera = {"name", "surnames", "age"};
    String  archivoDestino = "dataFile.txt";
    cdt.exportar(cabecera, archivoDestino, ",");
    
  }

}
