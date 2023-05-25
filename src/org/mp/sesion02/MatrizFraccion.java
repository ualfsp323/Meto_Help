package org.mp.sesion02;


public  class MatrizFraccion extends  MatrizGenerica<Number>{
	
	public  Fraccion sumar(Fraccion f1, Fraccion f2) {
		
	return f1.sumar(f2) ;
	
}
public Fraccion multiplicar(Fraccion f1, Fraccion f2) {
	
	return new Fraccion(f1.getNumerador() * f2.getNumerador(), f1.getDenominador() * f2.getDenominador());

}
public Fraccion cero() {
	return new Fraccion();

}
@Override
protected Number sumar(Number o1, Number o2) {
    Fraccion F1 = new Fraccion((Fraccion) o1);
    Fraccion F2 = new Fraccion((Fraccion) o2);

	return F1.sumar(F2) ;
}
@Override
protected Number multiplicar(Number o1, Number o2) {
	   Fraccion F1 = new Fraccion((Fraccion) o1);
	    Fraccion F2 = new Fraccion((Fraccion) o2);

		return F1.multiplicar(F2) ;
}


}
