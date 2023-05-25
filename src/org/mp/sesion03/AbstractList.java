package org.mp.sesion03;

public abstract class AbstractList<E> implements List<E> {

	protected int size = 0; // Tamaño de la lista

	/** Crea una lista por defecto */
	protected AbstractList() {
	}

	/** Crea una lista a partir de un array de objetos */
	protected AbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]); // añade por el final
	}

	/** Añade un nuevo elemento al final de la lista */
	public void add(E e) {
		add(size, e);
	}

	/** Devuelve true si la lista no contiene ningún elemento */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Devuelve el número de elementos de la lista */
	public int size() {
		return size;
	}

	/**
	 * Elimina la primera ocurrencia del elemento e de la lista. Busca el elemento
	 * e. Si lo encuentra, como devuelve la posición invoca al método remove(index)
	 * para eliminarlo. Devuelve true si el elemento se eliminó.
	 */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		} else
			return false;
	}
}
