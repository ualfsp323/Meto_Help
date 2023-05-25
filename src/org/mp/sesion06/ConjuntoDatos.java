package org.mp.sesion06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ConjuntoDatos {

	private File archivoTexto;
	private String separador;
	private Locale locale;
	private List cabecera;
	private int numeroLineas;
	private int numeroColumnas;
	private double datos[][];

	public ConjuntoDatos(File archivoTexto, String separador, Locale locale) throws IOException {
		this.archivoTexto = archivoTexto;
		this.separador = new String(separador);
		this.locale = locale;
		this.cabecera =getCabecera();
		this.datos=getDatos();
		this.numeroLineas=getNumeroLineas();
		this.numeroColumnas=getNumeroColumnas();
		   
	}
	private List cabecera(File archivoTexto) throws IOException {
		
		      BufferedReader br = new BufferedReader(new FileReader(archivoTexto));
		      String linea;
		      cabecera = new ArrayList();
		      numeroColumnas = 0;
             int a= getNumeroLineas();
             numeroLineas = 0;

		      while ((linea = br.readLine()) != null) {
		         String[] datosLinea = linea.split(separador);
		         if (numeroLineas == 0) {
		            cabecera.addAll(Arrays.asList(datosLinea));
		            numeroColumnas = datosLinea.length;
		            datos = new double[a][numeroColumnas];
		         } else {
		            for (int i = 0; i < numeroColumnas; i++) {
		               datos[numeroLineas - 1][i] = Double.parseDouble(datosLinea[i]);
		            }
		         }
		         numeroLineas++;
		      }

		      br.close();
		   
		return cabecera;
		
	}
	private int numLineas(File archivoTexto) throws IOException {
		 BufferedReader br = new BufferedReader(new FileReader(archivoTexto));
		   int numLineas = 0;

		   while (br.readLine() != null) {
		      numLineas++;
		   }

		   br.close();
		   return numLineas;		
	}
	private int numColumnas(File archivoTexto) throws IOException {
		 BufferedReader br = new BufferedReader(new FileReader(archivoTexto));
		   String linea;
		   int numColumnas = 0;

		   if ((linea = br.readLine()) != null) {
		      String[] datosLinea = linea.split(separador);
		      numColumnas = datosLinea.length;
		   }

		   br.close();
		   return numColumnas;	
	}
	private double[][] leerDatos(File archivoTexto,int fila,int columnas) throws IOException {
	
		 BufferedReader br = new BufferedReader(new FileReader(archivoTexto));
		   String linea;
		   fila = numLineas(archivoTexto)-1; 
	
			   		   columnas= numColumnas(archivoTexto);

		   double[][] datos = new double[fila][columnas];
		   numeroLineas=0;
		   while ((linea = br.readLine()) != null) {
		         String[] datosLinea = linea.split(separador);
		         if (numeroLineas == 0) {
		            datos = new double[fila][columnas];
		         } else {
		            for (int i = 0; i < columnas; i++) {
		               datos[numeroLineas - 1][i] = Double.parseDouble(datosLinea[i]);
		            }
		         }
		         numeroLineas++;
		      }
		         
		      

		   br.close();
		   return datos;		
	}
	public double [] getColumna(int columna) {
		
		double[] columnaDatos = new double[datos.length];

		   for (int i = 0; i < datos.length; i++) {
		      columnaDatos[i] = datos[i][columna];
		   }

		   return columnaDatos;	
   }
	
	public double []  getColumna(String columna) throws IOException {
		
		   int numColumna = -1;
		 List<String>  lista =cabecera(archivoTexto);
		   String[] cabecera = lista.toArray(new String[0]);
		   double[] columnaDatos = new double[datos.length];

		   for (int i = 0; i < cabecera.length; i++) {
		      if (cabecera[i].equals(columna)) {
		         numColumna = i;
		         break;
		      }
		   }

		   if (numColumna != -1) {
		      for (int i = 0; i < datos.length; i++) {
		         columnaDatos[i] = datos[i][numColumna];
		      }
		   }else {
			   for (int i = 0; i < datos.length; i++) {
			         columnaDatos[i] = datos[i][numColumna];
			      }		   }
		   

		   return columnaDatos;
		}
	public List getCabecera() throws IOException {
		cabecera =cabecera(archivoTexto);
		return cabecera;
	}
	public String getSeparador() {
		// TODO Auto-generated method stub
		return separador;
	}
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return locale;
	}
	public int getNumeroColumnas() throws IOException {
		numeroColumnas= numColumnas(archivoTexto);
		return numeroColumnas;
	}
	public int getNumeroLineas() throws IOException {
		numeroLineas= numLineas(archivoTexto);
		return numeroLineas-1;
	}
	public File getArchivoTexto() {
		// TODO Auto-generated method stub
		return archivoTexto;
	}
	public double[][] getDatos() throws IOException {
		
       datos= leerDatos(archivoTexto, getNumeroLineas(), getNumeroColumnas());
        
		return datos;
	}
	public void exportar(String[] cabecera, String archivoTexto, String separador) {
		try {
		      FileWriter writer = new FileWriter(archivoTexto);
		      writer.write(String.join(separador, cabecera) + "\n");
		      


		      
			 String[][]fila = new String[cabecera.length][datos.length];
		       double []cambio ;
		       
		      for (int i = 0; i < cabecera.length; i++) {
		         cambio=  getColumna(cabecera[i]);	
		         for (int j=0;j<cambio.length;j++) {
		        	  fila[i][j]=Double.toString(cambio[j]);
		         }
               
		      }
		     String[][] transpose = new String[fila[0].length][fila.length];
                for (int i = 0; i < fila.length; i++) {
		           for (int j = 0; j < fila[0].length; j++) {
		               transpose[j][i] = fila[i][j];
		           }
		       }
                for (int i = 0; i < transpose.length; i++) {
 		        	  String[] array1 = transpose[i]; 		
 		        	  writer.write(String.join(separador, array1) + "\n");
 		        	  }
 		          

		      writer.close();
		   } catch (IOException e) {
		      System.out.println("Error al escribir en el archivo.");
		      e.printStackTrace();
		   }		
	}
	
	public ConjuntoDatos conjuntoDatos(String[] cabecera, String archivoTexto, String separador, Locale locale) throws IOException {
		
		
		exportar(cabecera, archivoTexto, separador);
		File file = new File(archivoTexto); 
		ConjuntoDatos conjunto = new ConjuntoDatos(file, separador, locale);
           

		   return conjunto;
		
	}
		  
   }

