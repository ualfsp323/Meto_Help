package org.mp.sesion05;

import java.util.Comparator;

public class VolumenComparator implements Comparator {

	
	public int compare(Object o1, Object o2) {
		Accion otro1 = (Accion) o1;
		Accion otro2 = (Accion) o2;

		

		if (otro1.getVolumen() > otro2.getVolumen())
			return 1;
		else if (otro1.getVolumen() < otro2.getVolumen())
			return -1;
		else
			return 0;

	}
}


