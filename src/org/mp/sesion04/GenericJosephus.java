package org.mp.sesion04;

public class GenericJosephus<E> {
	private int k;
	private int n;
	private GenericQueue<E> cola;

	public GenericJosephus(int k, int n, E[] objects) {
		super();
		this.k = k;
		this.n = n;
		this.cola = new GenericQueue<E>();
		if (objects == null) {
			new GenericQueue<E>();
		} else {
			for (E element : objects) {
				cola.enqueue(element);
			}
			;
		}

	}

	public GenericQueue<E> getCola() {
		return cola;

	}

	@Override
	public String toString() {

		String s = "Problema de Josephus: k=" + k + ", n=" + n + "";

		return s + "\n" + cola;

	}

public String ordenEliminar(GenericQueue<E> cola) throws Exception {
  if (k==0 || n==0) {
	  throw new Exception ("No hay ninguna persona");
  }
  else if (k==1 || n==1) {
	  String s = "Solo hay una persona";
		return s;

}else {
		   

String a = "Orden de eliminación: " +"\n" ;
String [] arrayS = new String[cola.getSize()];		
String s="";

int count = 0;
while (cola.getSize() >= 1) {
	String b="";

    E removed = cola.dequeue();

    count++;
    if (count == k) {	
    	b = "Debe morir "+removed +"\n" ;

        count = 0;
    } else {
    	 cola.enqueue(removed);

    }
    s = s + b;

}
	return a+ s;


}

}
}
