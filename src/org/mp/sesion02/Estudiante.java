package org.mp.sesion02;

public class Estudiante extends Persona{
	private int nivel;
	
	public Estudiante(String nombre,String direccion,String telefono,String Email ,int nivel  ) {
		super(nombre, direccion,telefono,Email);
		this.nivel = nivel;
		
		};
	
		@Override
		public String toString() {			
			String Titulo;

			if (nivel==1) {
				Titulo="Grado";
			}else if(nivel==2) {
				Titulo="Máster";

			}else{
				Titulo="Doctorado";
			}
			
		
			String s = "Estudiante de "+ Titulo ;
			return    s+ "\n"+ super.toString();
		
	
      }
}
