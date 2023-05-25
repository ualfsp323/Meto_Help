package org.mp.sesion02;


public class Persona {

	private String nombre;
	private String direccion;
	private String telefono;
	private String Email;
	
	public Persona(String nombre,String direccion,String telefono,String Email) {
		super();
		this.nombre = new String(nombre);
		this.direccion = new String(direccion);
		this.telefono = new String(telefono);
		this.Email = new String(Email);
		
			}
	public Persona(Persona p) {
		super();
		this.nombre = new String(p.nombre);
		this.direccion = new String(p.direccion);
		this.telefono = new String(p.telefono);
		this.Email = new String(p.Email);
		
			}
		
	public String toString() {
		String salida = "Nombre = "+nombre+ ", Dirección = " + direccion +", Teléfono = "+telefono +", email = "+Email;
	
		return salida;
	}
	
}
