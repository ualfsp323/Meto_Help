package org.mp.sesion03;

import java.util.Iterator;

public interface List<E> extends Iterable<E> {

	/** Añade un nuevo elemento al final de la lista */
	public void add(E e);

	/**
	 * Añade un nuevo elemento en la posición especificiada por index en la lista
	 */
	public void add(int index, E e);

	/** Borra todos los elementos de la lista */
	public void clear();

	/** Devuelve true si la lista contiene el elemento e */
	public boolean contains(E e);

	/**
	 * Devuelve el elemento de la lista que esté en la posición especificada por
	 * index
	 */
	public E get(int index);

	/**
	 * Devuelve el índice de la primera ocurrencia del elemento e en la lista.
	 * Devuelve -1 si no está.
	 */
	public int indexOf(E e);

	/** Devuelve true si la lista no tiene elementos */
	public boolean isEmpty();

	/**
	 * Devuelve el índice de la última ocurrencia del elemento e en la lista.
	 * Devuelve -1 si no está.
	 */
	public int lastIndexOf(E e);

	/**
	 * Borra la primera ocurrencia del elemento e en la lista. Desplaza la
	 * subsecuencia de elementos a la izquierda. Devuelve true si el elemento se ha
	 * borrado.
	 */
	public boolean remove(E e);

	/**
	 * Borra el elemento de la posición especificada por index de la lista. Desplaza
	 * la subsecuencia de elementos a la izquierda. Devuelve el elemento que ha sido
	 * borrado de la lista.
	 */
	public E remove(int index);

	/**
	 * Sustituye el elemento de la posición especificada por index en la lista por
	 * el elemento e y devuelve el elemento antiguo
	 */
	public E set(int index, E e);

	/** Devuelve el número de elementos de la lista */
	public int size();

	@Override
	default Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
