package org.mp.sesion03;

import java.util.Iterator;
import java.util.NoSuchElementException;


// TODO: Auto-generated Javadoc
/**
 * The Class LinkedList.
 *
 * @param <E> the element type
 */
public class LinkedList<E> extends AbstractList<E> {
	 
 	/**
 	 * The Class Node.
 	 *
 	 * @param <E> the element type
 	 */
 	public static class Node<E> {
		
		/** The item. */
		public E item;
		
		/** The element. */
		E element;
        
        /** The next. */
        public Node<E> next;
        
        /** The prev. */
        Node<E> prev;

		/**
		 * Instantiates a new node.
		 *
		 * @param e the e
		 */
		public Node(E e) {
			element = e;
		}

		/**
		 * Instantiates a new node.
		 *
		 * @param prev the prev
		 * @param element the element
		 * @param next the next
		 */
		public Node(Node<E> prev,E element, Node<E> next) {
            this.prev = prev;
			this.item = element;
			this.next = next;
		}
	
	}
	 
 	/**
 	 * Node.
 	 *
 	 * @param index the index
 	 * @return the node
 	 */
 	protected Node<E> node(int index) {

		        if (index < (size >> 1)) {
		        	Node<E> x = head;
		          for (int i = 0; i < index; i++)
		                x = x.next;
		            return x;
		        } else {
		            Node<E> x = tail;
		            for (int i = size - 1; i > index; i--)
		                x = x.prev;
		            return x;
		        }
		    }
	 
	/** The tail. */
	protected Node<E> head;
	protected Node<E> tail;

	/**
	 * Instantiates a new linked list.
	 */
	public LinkedList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new linked list.
	 *
	 * @param objects the objects
	 */
	public LinkedList(E[] objects) {
		super(objects);

	}

	/**
	 * Gets the first.
	 *
	 * @return the first
	 */
	public E getFirst() {
		if (head == null)
			return null;
		return head.item;
	}

	/**
	 * Gets the last.
	 *
	 * @return the last
	 */
	public E getLast() {
		if (tail == null)
			return null;
		return tail.item;
	}

	/**
	 * Adds the first.
	 *
	 * @param e the e
	 */
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
	 * @param e the e
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
			current.next =  new Node<>(null, e, head);
			(current.next).next = temp;
			size++; // incrementa el tamaño
		}
	}

	/**
	 * Removes the first.
	 *
	 * @return the e
	 */
	public E removeFirst() {
		if (size == 0)
			return null; // Nada que borrar
		else {
			Node<E> temp = head; // conserva el primer nodo temporalmente
			head = head.next; // mueve head para apuntar al siguiente nodo
			size--; // reduce en 1 el tamaño
			if (head == null)
				tail = null; // la lista se pone vacia
			return temp.item; // devuelve el elemento borrado
		}
	}

	/**
	 * Removes the last.
	 *
	 * @return the e
	 */
	public E removeLast() {
		if (size == 0)
			return null; // Nada que eliminar
		else if (size == 1) { // solo un elemento en la lista
			Node<E> temp = head;
			head = tail = null; // la lista la hacemos vacía
			size = 0;
			return temp.item;
		} else {
			Node<E> current = head;
			for (int i = 0; i < size - 2; i++)
				current = current.next;
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.item;
		}
	}
	
	/**
	 * Removes the.
	 *
	 * @param index the index
	 * @return the e
	 */
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size)
			return null;// Fuera de rango
		else if (index == 0)
			return removeFirst();// elimina el primero
		else if (index == size - 1)
			return removeLast();// elimina el último
		else {
			Node<E> previous = head;
			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.item;
		}
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("[");
		  Node current = head;
		for (int i = 0; i < size; i++) {
	    	resultado.append(current.item);
	        current = current.next;
			if (i < size - 1)
				resultado.append(", ");
		}
		return resultado.toString() + "]";
	}
	
	/**
	 * Clear.
	 */
	@Override
	public void clear() {
		for (Node<E> x = head; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        head = tail = null;
        size = 0;
	}

	/**
	 * Contains.
	 *
	 * @param e the e
	 * @return true, if successful
	 */
	@Override
	public boolean contains(E e) {
        return indexOf(e) >= 0;
	}

	/**
	 * Gets the.
	 *
	 * @param index the index
	 * @return the e
	 */
	@Override
	public E get(int index) {
        return node(index).item;
	}

	/**
	 * Index of.
	 *
	 * @param e the e
	 * @return the int
	 */
	@Override
	public int indexOf(E e) {
		  int index = 0;
	        if (e == null) {
	            for (Node<E> x = head; x != null; x = x.next) {
	                if (x.item == null)
	                    return index;
	                index++;
	            }
	        } else {
	            for (Node<E> x = head; x != null; x = x.next) {
	                if (e.equals(x.item))
	                    return index;
	                index++;
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
		 int index = size;
	        if (e == null) {
	            for (Node<E> x = tail; x != null; x = x.prev) {
	                index--;
	                if (x.item == null)
	                    return index;
	            }
	        } else {
	            for (Node<E> x = tail; x != null; x = x.prev) {
	                index--;
	                if (e.equals(x.item))
	                    return index;
	            }
	        }
	        return -1;
	}



	/**
	 * Sets the.
	 *
	 * @param index the index
	 * @param e the e
	 * @return the e
	 */
	@Override
	public E set(int index, E e) {
		   Node<E> x = node(index);
		   if (x==null) {
		        return null;

		   }
	        E oldVal = x.item;
	        x.item = e;
	        return oldVal;
	}

	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */
	@Override
	/** Sobre-escribe el método iterator() definido en Iterable */
	public Iterator<E> iterator() {
	    return (Iterator<E>) new LinkedListIterator();
	}

	/**
	 * The Class ArrayListIterator.
	 */
	private class LinkedListIterator implements Iterator<E> {
        
        /** The next index. */
        private int nextIndex=0;      
        
        /** The last returned. */
        private Node<E> lastReturned = head;
        
        /** The next. */
        private Node<E> next = head;
         
        /**
         * Instantiates a new linked list iterator.
         */
        LinkedListIterator() {}

        /**
         * Checks for next.
         *
         * @return true, if successful
         */
        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }
        
        /**
         * Next.
         *
         * @return the e
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            
           E lastReturned = get(nextIndex);
            next =next.next;
            nextIndex++;
            return lastReturned;
        }

       
        /**
         * Removes the.
         */
        @Override
        public void remove() {
        	if(next == null) {
        		lastReturned=null;
        		size--;

        	}else {
        	Node<E> lastReturned = head; // conserva el primer nodo temporalmente
			head = head.next; // mueve head para apuntar al siguiente nodo
    		
    		size--;
        	  Node<E> lastNext = lastReturned.next;
              if (next == lastReturned)
                  next = lastNext;
              else
                  nextIndex--;
              lastReturned = null;
        	}
        }

	  
	     

}
}
