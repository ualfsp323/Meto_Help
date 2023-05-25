package org.mp.sesion02;


public class Octogono extends ObjetoGeometrico implements DeColor, Cloneable, Comparable<Object>{

	private double lado;
	

	public Octogono(String color, boolean relleno, double lado ) {
		super(color, relleno);
		this.lado =lado;
		
			}
	public Octogono() {
		super();
		}
	public  double getLado() {
		return lado;
	}
	
	public void setLado(double lado) {
    this.lado=lado;		
	}
	
	public double getPerimetro() {
		
		  
		return 8*lado;
}
public double getArea() {
 
    double area1= 2+ (4/Math.sqrt(2));
	return lado*lado*area1;

}
@Override
public Object clone() {
	try {
		return super.clone();
	} catch (CloneNotSupportedException ex){
		return null;
	}
}
	public int compareTo(Object o) {

		Octogono otro = (Octogono) o;


		if (lado > otro.lado)
			return 1;
		else if (lado < otro.lado)
			return -1;
		else
			return 0;

	}
	
	 public String comoColorear() {

		return "Colorear los 8 lados de "+getColor();
	}
}
