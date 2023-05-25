package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Administrativo extends Empleado {
	private String Unidad_Destino;
	
	public Administrativo(String nombre,String direccion,String telefono,String Email, String despacho,int salario,GregorianCalendar Fecha_contratacion, String Unidad_Destino) {
		super(nombre, direccion,telefono,Email,despacho,salario,Fecha_contratacion);
		this.Unidad_Destino = new String(Unidad_Destino);
		
			}
	@Override
	public String toString() {			
	
		
		String s = "Destinado en la unidad "+Unidad_Destino;
		
        return "Administrativo"+ "\n"+super.toString() + "\n" + s;
	

  }
}
