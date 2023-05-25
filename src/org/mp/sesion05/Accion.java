package org.mp.sesion05;


public class Accion implements Comparable{
    private String nombre;
    private long volumen;
    
	public Accion(String nombre, long volumen) {
         this.nombre= new String(nombre);
         this.volumen=volumen;
	}
	
	public  String getNombre() {
		return nombre;
	}
	
	public  void setNombre( String nombre) {
        this.nombre= new String(nombre);
	}
	
	public  long getVolumen() {
		return volumen;
	}
	
	public  void setVolumen( long volumen) {
        this.volumen=volumen;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Accion otro = (Accion) obj;
		return volumen == otro.volumen;
	}
	
	@Override
	public String toString() {
		return  "a";
	}
	
	@Override
	public  int compareTo(Object o) {

		Accion otro = (Accion) o;

		if (volumen > otro.volumen)
			return 1;
		else if (volumen < otro.volumen)
			return -1;
		else
			return 0;

	}

}
