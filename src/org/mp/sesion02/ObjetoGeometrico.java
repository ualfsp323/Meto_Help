package org.mp.sesion02;

import java.util.GregorianCalendar;


public abstract class ObjetoGeometrico {
	private String color = "blanco";
	private boolean relleno = false;
	protected GregorianCalendar fechaCreado;

	public ObjetoGeometrico() {
		super();
		fechaCreado = new GregorianCalendar();

	}

	public ObjetoGeometrico(String color, boolean relleno) {
		super();
		this.color = new String(color);
		this.relleno = relleno;
		fechaCreado = new GregorianCalendar();

	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = new String(color);
	}
	
	public boolean esRelleno() {
		return relleno;
	}
	
	public void setRelleno(boolean relleno) {
		this.relleno=relleno;
	}
	
	public GregorianCalendar getFechaCreado() {
		return fechaCreado;
	}
	
	@Override
	public String toString() {			

	
		String s = "Creado el "+fechaCreado + "\ncolor: "+color+" y es relleno: "+relleno;
		
        return  s;
	

  }

	public abstract double getPerimetro();

	public abstract double getArea();
	
}
