package org.mp.sesion02;

public class MatrizInteger extends  MatrizGenerica{

	protected Integer sumar(Integer o1, Integer o2) {
	
		return new Integer( o1 + o2);

	}

	public Integer multiplicar(Integer o1, Integer o2) {
		
		return new Integer( o1 * o2);

	}


	public Integer cero() {
		return 0;

	}

	@Override
	protected Number sumar(Number o1, Number o2) {
		// TODO Auto-generated method stub
		return new Integer((Integer) o1 +(Integer) o2);
	}

	@Override
	protected Number multiplicar(Number o1, Number o2) {
		// TODO Auto-generated method stub
		return new Integer((Integer) o1 * (Integer) o2);

	}

}

