package org.mp.sesion02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorPrimos implements Iterator<Integer> {
	private int limite;
	private int actual = 2;

	public IteradorPrimos(int limite) {
		this.limite = limite;

	}

	public int getLimite() {
		return limite;
	}

	public int getActual() {
		return actual;
	}

	public boolean hasNext() {
		if (actual > limite)
			return false;
		else
			return true;
	}

	@Override
	public Integer next() {

		if (actual > limite)
			throw new NoSuchElementException("No se puede acceder a más números primos");

		int temp = actual;

		do {
			actual++;
		} while (!esPrimo(actual));

		return new Integer(temp);

	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Método no soportado");
	}

	public static boolean esPrimo(int numero) {
		if (numero <= 1) {
			return false;
		}

		int contador = 0;

		for (int i = (int) Math.sqrt(numero); i > 1; i--) {
			if (numero % i == 0) {
				contador++;
			}
		}

		return contador < 1;
	}

	public String mostrarPrimos() {
		Iterator<Integer> iter = new IteradorPrimos(limite);
		String s = "";
		int contador = 1;

		if (actual > limite) {
			s = "";
		}

		while (iter.hasNext()) {
			String b;
			if (contador == 11) {

				contador = 1;
				b = "\n" + "\t" + iter.next();

			} else {

				b = "\t" + iter.next();
			}
			s = s + b;

			contador++;
		}

		return s;
	}
}
