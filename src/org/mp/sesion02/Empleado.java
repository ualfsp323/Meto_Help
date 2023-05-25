package org.mp.sesion02;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Empleado extends Persona{
	private String despacho;
	private int salario;
	private GregorianCalendar Fecha_contratacion;
	
	public Empleado(String nombre,String direccion,String telefono,String Email, String despacho,int salario,GregorianCalendar Fecha_contratacion ) {
		super(nombre, direccion,telefono,Email);
		this.despacho = new String(despacho);
		this.salario =salario;
		this.Fecha_contratacion = Fecha_contratacion;
		
			}
	@Override
	public String toString() {			

	int a=Fecha_contratacion.get(Calendar.MONTH);
	a++;
		String s = "Despacho = "+despacho + ", salario = "+salario+", Fecha de contratación = "+Fecha_contratacion.get(Calendar.DATE)+"/"+a+"/"+Fecha_contratacion.get(Calendar.YEAR);
		
        return super.toString() + "\n" + s;
	

  }

}
