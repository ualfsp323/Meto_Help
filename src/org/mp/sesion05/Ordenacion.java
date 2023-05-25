package org.mp.sesion05;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ordenacion {

	public static void ordenacionPorInsercion(Comparable[] a) {
		ordenacionPorInsercion(a, 0, a.length - 1);

	}

	private static void ordenacionPorInsercion(Comparable[] a, int izq, int der) {
		int j;
		Comparable temp;
		for (int i = izq + 1; i <= der; i++) {
			temp = a[i];
			for (j = i; j > izq && (temp.compareTo(a[j - 1]) < 0); j--) {
				a[j] = a[j - 1];
			}
		}

	}

	public static void mergeSort(Comparable[] a) {
		Comparable[] Temp = new Comparable[a.length];
		mergeSort(a, Temp, 0, a.length - 1);
	}

	private static void mergeSort(Comparable[] a, Comparable[] Temp, int izq, int der) {
		if (izq < der) {
			int medio = (izq + der) / 2;
			mergeSort(a, Temp, izq, medio);
			mergeSort(a, Temp, medio + 1, der);
			mezclar(a, Temp, izq, medio+1, der);
		}

	}

	private static void mezclar(Comparable[] a, Comparable[] Temp, int posIzq, int posDer, int posFin) {
		int posFinIzq = posDer - 1;
		int posT = posIzq;
		int numElementos = posFin - posIzq + 1;
		while ((posIzq <= posFinIzq) && (posDer <= posFin)) {
			if (a[posIzq].compareTo(a[posDer]) <= 0) {
				Temp[posT++] = a[posIzq++];

			} else {
				Temp[posT++] = a[posDer++];

			}

		}
		while(posIzq<=posFinIzq) {
			Temp[posT++] = a[posIzq++];
		}
		
		while ( posDer <= posFin) {
			Temp[posT++] = a[posDer++];

		}
		for (int i = 0; i < numElementos; i++,posFin--) {
			a[posFin]=Temp[posFin];
		}

	}
	public static void sort(Comparable[] a) {
		Arrays.sort(a);
	}


}
