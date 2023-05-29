package tema06;

public class PruebaPropiedades {

  public static void main(String args[]) {

    // Todas las propiedades por defecto del sistema
    java.util.Properties properties = System.getProperties();
    //properties.list(System.out);
    System.out.println(properties);    
    System.out.println("========================================");
    
    // Home
    String path = System.getProperty("user.home");
    System.out.println("Home Path: " + path);
    System.out.println("========================================");
    
    // Sistema operativo
    String os = System.getProperty("os.name");
    System.out.println("Operating System: " + os);
    System.out.println("========================================");
    
    // Directorio actual de trabajo
    String dir = System.getProperty("user.dir");
    System.out.println("Working directory: " + dir);
    System.out.println("========================================");
    
    // Separador de archivos
    String fileSep = System.getProperty("file.separator");
    System.out.println("File separator: " + fileSep);
    System.out.println("========================================");
    
    // Otras propiedades
    // https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html

  }

}
