package org.mp.sesion05;

import java.util.Comparator;

public class NumeroPaloComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Carta card1 = (Carta) o1;
		Carta card2 = (Carta) o2;

		
	        if (card1.getNumero() == card2.getNumero()) {
	            return card1.getPalo().compareTo(card2.getPalo());
	        }
	        return Integer.compare(card1.getNumero(), card2.getNumero());
	    }
		
	

}
