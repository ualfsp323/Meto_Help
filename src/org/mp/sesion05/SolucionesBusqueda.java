package org.mp.sesion05;

public class SolucionesBusqueda {

	public static int busquedaLineal(Busqueda busqueda) throws ElementoNoEncontradoException{
		int buscado;
		buscado=busqueda.getNumBuscado();		
		boolean encontrado = false;
		int []datos =busqueda.getDatos();
		for (int i = 0; i < datos.length; i++) {
			if (buscado==datos[i]) {
				encontrado=true;
				break;
			}
		}
		if(!encontrado) {
			throw new ElementoNoEncontradoException("No encontrado");
		}else {
			return buscado;
		}
	}

public static int busquedaBinariaRec(Busqueda busqueda) throws ElementoNoEncontradoException {
int inicio=0;
int []datos =busqueda.getDatos();
int ultimo = datos.length -1;
int buscado=busqueda.getNumBuscado();	
busquedaBinariaRec(datos,buscado,inicio,ultimo);
if (busquedaBinariaRec(datos, buscado, inicio, ultimo)==-1) {
	throw new ElementoNoEncontradoException("No encontrado");

}else {
	return buscado;

}
	}

	private static int busquedaBinariaRec(int[] datos, int buscado, int inicio, int ultimo) {
		// TODO Auto-generated method stub
		 if (inicio <= ultimo) {
		        int mid = inicio + (ultimo - inicio) / 2;
		        if (datos[mid] == buscado) {
		            return mid;
		        } else if (datos[mid] > buscado) {
		            return busquedaBinariaRec(datos,buscado , inicio, mid - 1);
		        } else {
		            return busquedaBinariaRec(datos,buscado , mid + 1, ultimo);
		        }
		    }
		    return -1;
	}

	public static int busquedaBinariaIter(Busqueda busqueda) throws ElementoNoEncontradoException{
		int inicio=0;
		int []datos =busqueda.getDatos();
		int ultimo = datos.length -1;
		int buscado=busqueda.getNumBuscado();	
		boolean encontrado = false;

	    while (inicio <= ultimo) {
	        int mid = inicio + (ultimo - inicio) / 2;
	        if (datos[mid] == buscado) {
	    		encontrado=true;
				break;	       
			} else if (datos[mid] < buscado) {
	        	inicio = mid + 1;
	        } else {
	        	ultimo = mid - 1;
	        }
	    }
	    
		if(!encontrado) {
			throw new ElementoNoEncontradoException("No encontrado");
		}else {
			return buscado;
		}	   
	}

}
