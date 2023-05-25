package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Profesor extends Empleado {
	private String Horario;
	private int Categoria;
	
	public Profesor(String nombre,String direccion,String telefono,String Email, String despacho,int salario,GregorianCalendar Fecha_contratacion, String Horario,
	 int Categoria) {
		super(nombre, direccion,telefono,Email,despacho,salario,Fecha_contratacion);
		this.Horario = new String(Horario);
		this.Categoria =Categoria;
		
			}
	@Override
	public String toString() {			
		String Titulo;

		if (Categoria==1) {
			Titulo="Ayudante";
		}else if(Categoria==2) {
			Titulo="Titular de Universidad";

		}else {
			Titulo="Catedrático de Universidad";
		}
	
		String s = "Profesor "+ Titulo ;
		return    s+ "\n"+ super.toString() +"\nHorario = "+Horario;
		

  }
}
