package org.mp.sesion04;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.mp.sesion03.LinkedList;
import org.mp.sesion03.LinkedList.Node;

public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E> {
	public SortedLinkedList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new linked list.
	 *
	 * @param objects the objects
	 */
	public SortedLinkedList(Comparable<E>[] objects) {

	}

	@Override
	public void addFirst(E e) {
		Node<E> nuevoNodo = new Node<>(null, e, head); // Crea un nodo
		nuevoNodo.next = head; // enlaza el nuevoNodo con la cabeza
		head = nuevoNodo; // la cabeza apunta al nuevoNodo
		size++; // incrementa el tamaño de la lista
		if (tail == null) // si la lista está vacia
			tail = head; // el nuevoNodo es el único en la lista
	}

	/**
	 * Adds the last.
	 *
	 * @param e the e
	 */
	@Override
	public void addLast(E e) {
		Node<E> nuevoNodo = new Node<>(tail, e, null); // Crea un nuevo nodo para e
		if (tail == null) {
			head = tail = nuevoNodo; // El único nodo en la lista
		} else {
			tail.next = nuevoNodo;// enlaza el nuevo nodo con el último nodo
			tail = tail.next; // la cola apunta ahora al último nodo
		}
		size++; // incrementa el tamaño
	}

	/**
	 * Adds the.
	 *
	 * @param index the index
	 * @param e     the e
	 */
	@Override
	public void add(int index, E e) {
		if (index <= 0)
			addFirst(e); // Inserta al principio
		else if (index >= size)
			addLast(e); // Inserta al final
		else {// Inserta en medio
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<>(null, e, head);
			(current.next).next = temp;
			size++; // incrementa el tamaño
		}
	}

	@Override
	public E set(int index, E e) {
		Node<E> x = node(index);
		if (x == null) {
			return null;

		}
		E oldVal = x.item;
		x.item = e;
		return oldVal;
	}

	public void addSorted(Comparable<E> E) {

		int i;
		for (i = 0; i < size(); i++) {
			if (E.compareTo(get(i)) <= 0) {
				set(i, (E) E);
			}
		}

		add((E) E);
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("Lista ordenada: [");
		Node current = head;
		for (int i = 0; i < size; i++) {
			resultado.append(current.item);
			current = current.next;
			if (i < size - 1)
				resultado.append(", ");
		}
		return resultado.toString() + "]";
	}
}