package org.mp.sesion02;

public class Busqueda {

	public static int busquedaBinaria(Integer[] enteros, int numeroBuscado) {
		for (int i = 0; i < enteros.length; i++) {
			if (enteros[i]==(numeroBuscado)) {
				return i;
			}
			
		}	
	return -1;
	}

	public static int busquedaBinaria(Double[] reales, double numeroBuscado) throws ExcepcionArrayVacio {
	
		if (reales.length == 0) {
			throw new ExcepcionArrayVacio("Array vacío");
		}
		for (int i = 0; i < reales.length; i++) {
			if (reales[i]==(numeroBuscado)) {
				return i;
			}
			
		}	
	return -1;
	}


	public static int busquedaBinaria(String[] apellidos, String string)  {
		for (int i = 0; i < apellidos.length; i++) {
			if (apellidos[i]==(string)) {
				return i;
			}
			
		}	
	return -1;
	}
	
	public static int busquedaBinaria(Fraccion[] fracciones, Fraccion fraccion) {
		for (int i = 0; i < fracciones.length; i++) {
			if (fracciones[i].equals(fraccion)) {
				return i;
			}
			
		}	
	return -1;
	}
}

class ExcepcionArrayVacio extends Exception {
	public ExcepcionArrayVacio(String mensaje) {
		super(mensaje);
	}

}
