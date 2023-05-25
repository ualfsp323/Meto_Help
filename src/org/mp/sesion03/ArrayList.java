package org.mp.sesion03;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO: Auto-generated Javadoc
/**
 * Clase ArrayList.
 *
 * @param <E> el tipo elemento
 */
public class ArrayList<E> extends AbstractList<E> {

	/** La variable CAPACIDAD_INICIAL. */
	private static final int CAPACIDAD_INICIAL = 16;

	/** la variable data. */
	@SuppressWarnings("unchecked")
	private E[] data = (E[]) new Object[CAPACIDAD_INICIAL]; // Crea un array

	/**
	 * Instantiates a new array list.
	 */
	public ArrayList() {

	}

	/**
	 * Instantiates a new array list.
	 *
	 * @param objects the objects
	 */
	public ArrayList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/**
	 * Adds the.
	 *
	 * @param index the index
	 * @param e the e
	 */
	@Override /** Añade un nuevo elemento en la posición especifica por index */
	public void add(int index, E e) {
		checkIndex(index);
		ensureCapacity();
		System.arraycopy(data, index, data, index + 1, size - index);
		data[index] = e;
		size++;
	}

	/**
	 * Ensure capacity.
	 */
	private void ensureCapacity() {
		if (data.length == size) {
			E[] newArray = (E[]) new Object[data.length * 2 + 1];
			System.arraycopy(data, 0, newArray, 0, data.length);
			data = newArray;
		}

	}

	/**
	 * Clear.
	 */
	@Override
	public void clear() {
		this.size = 0;
		this.data = (E[]) new Object[CAPACIDAD_INICIAL];
	}

	/**
	 * Contains.
	 *
	 * @param e the e
	 * @return true, if successful
	 */
	@Override
	public boolean contains(E e) {

		for (int i = 0; i < data.length; i++) {
			if (data[i] == (e)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets .
	 *
	 * @param index the index
	 * @return the e
	 */
	@Override
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	/**
	 * Check index.
	 *
	 * @param index the index
	 */
	private void checkIndex(int index) {
		if (index > size || index < 0 ) {
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
		}

	}

	/**
	 * Index of.
	 *
	 * @param e the e
	 * @return the int
	 */
	@Override
	public int indexOf(E e) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == (e)) {
				return i;
			}

		}
		return -1;
	}

	/**
	 * Last index of.
	 *
	 * @param e the e
	 * @return the int
	 */
	@Override
	public int lastIndexOf(E e) {

		for (int i = data.length - 1; i >= 0; i--) {
			if (data[i] == (e)) {
				return i;
			}

		}
		return -1;

	}

	/**
	 * Removes .
	 *
	 * @param index the index
	 * @return the e
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		checkIndex(index);
		if (size == 0 && index == 0 || index == size) {
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);

		}
		Object[] es = data;
		@SuppressWarnings("unchecked")
		E oldValue = (E) es[index];
		int newSize;
		if ((newSize = size - 1) > index)
			System.arraycopy(es, index + 1, es, index, newSize - index);
		es[size = newSize] = null;

		return oldValue;

	}

	/**
	 * Sets .
	 *
	 * @param index the index
	 * @param e the e
	 * @return the e
	 */
	@Override
	public E set(int index, E e) {

		checkIndex(index);
		if (size == 0 && index == 0 || index == size) {
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
		}
		E antiguo = data[index];
		data[index] = e;
		return antiguo;

	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			resultado.append(data[i]);
			if (i < size - 1)
				resultado.append(", ");
		}
		return resultado.toString() + "]";
	}

	/**
	 * Trim to size.
	 */
	public void trimToSize() {
		int size = size();

		if (size < data.length) {
			E[] newArray = (E[]) new Object[CAPACIDAD_INICIAL];
			System.arraycopy(data, 0, newArray, 0, size);
			data = newArray;
		} else {
			throw new RuntimeException("Guapit@ no necesitas hacer un trim, el tamaño coincide con la capacidad");
		}
	}

/**
 * Iterator.
 *
 * @return the java.util. iterator
 */
@Override /** Sobre-escribe el método iterator() definido en Iterable */
public java.util.Iterator<E> iterator() {
    return (Iterator<E>) new ArrayListIterator();
}

/**
 * The Class ArrayListIterator.
 */
private class ArrayListIterator implements Iterator<E> {
    
    /** The current. */
    int current;      
    
    /** The last ret. */
    int lastRet = -1; 
    
    /**
     * Instantiates a new array list iterator.
     */
    ArrayListIterator() {}

    /**
     * Checks for next.
     *
     * @return true, if successful
     */
    public boolean hasNext() {
        return current != size;
    }

    /**
     * Next.
     *
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public E next() {
        int i = current;
        if (i >= size){
			throw new NoSuchElementException("No hay más elementos en la lista");
            }
        Object[] elementData = ArrayList.this.data;
        if (i >= elementData.length) {
        	checkIndex(i);
        }
        current = i + 1;
        return (E) elementData[lastRet = i];
    }

    /**
     * Removes the.
     */
    public void remove() {
        if (lastRet < 0) {
			throw new IndexOutOfBoundsException("Indice: " + current + ", Tamaño: " + size);
        }
            ArrayList.this.remove(lastRet +1);
            current = lastRet;
            lastRet = -1;
        } 
    }

  
     
}