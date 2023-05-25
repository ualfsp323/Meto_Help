package org.mp.sesion07;

public class Banda<T extends Number> {
private String nombreBanda;
private T[][] datos;


public void Banda(String nombre, int x, int y) {
	
    this.nombreBanda = new String (nombre);
    this.datos = (T[][]) new Number[x][y];
   
 }
public void Banda(String nombre, T[][]datos) {
	
    this.nombreBanda = new String (nombre);
    this.datos = datos;
 }
public String getNombreBanda() {
	return this.nombreBanda;
}
public void setNombreBanda(String nombreBanda) {
	 this.nombreBanda=new String (nombreBanda);
}
public T[][] getDatos() {
	return datos;
}
public void setDatos(T[][] datos) {
	 this.datos=datos;
}
public T getDatoXY(int x, int y) {
	return datos[x][y];
}
public void setDatoXY(T dato, int x ,int y) {
	 datos[x][y]=dato;
}
public String toString() {
	 String s ="";
		for (int i=0; i < datos.length; i++) {		  
			String b="";

			  for (int j=0; j < datos[i].length; j++) {
			  b= datos[i][j]+"";
			    if (j!=datos[i].length-1)s=s+b+"\t" ;
			    else s=s+b+"";
			    

			  }
			   if (i!=datos[i].length-1)s=s+"\n";
			    else s=s+"";
			  
			} 
		
	return    "BandaIntegers:"+ "\n"+ s;
}
}


