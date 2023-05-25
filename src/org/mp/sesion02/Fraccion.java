package org.mp.sesion02;


/**
 * <h1>Fraccion</h1>
 *  @author Franco.P MP2023
 *  @version 13.02.2023
 *  */
public class Fraccion extends Number implements  Comparable<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8909363198158506297L;
	private int numerador;
	private int denominador;
/** 
 * Constructor default.
 */
	public Fraccion() {
		numerador = 0;
		denominador = 1;
	}
	/** 
	 * Constructor parametro.
	 * @param numerador
	 * Fraccion: numerador.
	 * @param denominador
	 * Fraccion: denominador.
	 * 
	 */

	public Fraccion(int numerador, int denominador) {

		this.numerador = ((denominador > 0) ? 1 : -1) * numerador;
		this.denominador = Math.abs(denominador);

	}
	public Fraccion(Fraccion frac) {
		super();
		this.numerador = frac.numerador;
		this.denominador = frac.denominador;

	
	}
	/** 
	 * Comprueba que dos fracciones sean o no sean iguales.
	 * @return Boolean: True si las fracciones son iguale y false si no.
	 */

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Fraccion))
			return false;
		Fraccion otro = (Fraccion) obj;
		if (denominador != otro.denominador)
			return false;
		if (numerador != otro.numerador)
			return false;
		return true;
	}
	
	/** 
	 * GetterNumerador.
	 * @return fraccion: numerador.
	 */

	public int getNumerador() {
		return numerador;
	}
	
	/** 
	 * GetterDenominador.
	 * @return fraccion: denominador.
	 */
	public int getDenominador() {
		return denominador;
	}
	
	/** 
	 * Genera un string dependiendo del valor del denumerador.
	 * @return String: solo el numerador si el denominador es 1, con denominador lo pondria <b>"Numerador" / "Denominador"</b>.
	 */
	@Override
	public String toString() {
		if (denominador == 1)
			return numerador + "";
		else
			return numerador + "/" + denominador;
	}
	
	/** 
	 * Hace la suma de dos Fracciones
	 * @param b
	 * Fraccion: copia del segunda fraccion que pongas.
	 * @return fraccion(sumar): Hace las cuentas necesarias para sumar dos fracciones, hay que pasarlas por un parametro tal que asi <b>frac1.sumar(frac2)</b> donde frac1 sera Franccion y "b" sera frac2.
	 */

	public Fraccion sumar(Fraccion b) {
		int num = numerador * b.getDenominador() + denominador * b.getNumerador();
		int den = denominador * b.getDenominador();
		return new Fraccion(num, den);

	}
	
	/** 
	 * Hace la resta de dos Fracciones
	 * @return fraccion(restar): Hace las cuentas necesarias para restar dos fracciones, hay que pasarlas por un parametro tal que asi <b>frac1.restar(frac2)</b>.
	 */

	public Fraccion restar(Fraccion b) {
		int num = numerador * b.getDenominador() - denominador * b.getNumerador();
		int den = denominador * b.getDenominador();
		return new Fraccion(num, den);
	}
	
	/** 
	 * Hace la multiplicacion de dos Fracciones
	 * @return fraccion(multiplicar): Hace las cuentas necesarias para multiplicar dos fracciones, hay que pasarlas por un parametro tal que asi <b>frac1.multiplicar(frac2)</b>.
	 */

	public Fraccion multiplicar(Fraccion b) {
		return new Fraccion(numerador * b.getNumerador(), denominador * b.getDenominador());
	}
	
	/** 
	 * Hace la division de dos Fracciones
	 * @return fraccion(dividir): Hace las cuentas necesarias para dividir dos fracciones, hay que pasarlas por un parametro tal que asi <b>frac1.dividir(frac2)</b>.
	 */
	
	public Fraccion dividir(Fraccion b) {
		return new Fraccion(numerador * b.getDenominador(), denominador * b.getNumerador());
	}
	
	/** 
	 * Hace el maximo comun divisor de una Fraccion.
	 * @param u
	 * int: parte del numerador de la fraccion.
	 * @param v
	 * int: parte del denominador de la fraccion.
	 * @return int: Escoge el numerador y lo pasa a una variable <b>"u"</b> y lo mismo con el denominador, pero en la variable <b>"v"</b> con ello y la variable "comodin (r)" podemos crear un bucle donde haremos el algorimo de EUCLIDES hasta que la variable "v" llege a 0, luego devolvera el valor de "u".
	 */
	
	private static int mcd(int u, int v) {
		u = Math.abs(u);
		v = Math.abs(v);
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	/** 
	 * Pasa las fracciones normales a simplificadas
	 * @param dividir
	 * int: consigue el mcd de las dos partes de la fraccion
	 * @return devuelve cualquier fraccion simplificada.
	 */

	public Fraccion simplificar() {
		int dividir = mcd(numerador, denominador);
		numerador /= dividir;
		denominador /= dividir;
		return this;
	}

	/** 
	 * Compara dos fracciones.
	 * @param valorFraccion
	 * double: pasa los valores de la fraccion de int a double donde sera el primer fraccion donde se guarde en esta variable.
	 * @param valorOtro
	 * double: agarra los valores de la segunda fraccion que queremos comparar con la primera.
	 * @return Devuelve 1 si la variable <b>valorFraccion</b> es mayor que la variable <b>valorOtro</b>, -1 si es al reves y por ultimo 0 si son iguales.
	 */
	
	public int compareTo(Object o) {

		Fraccion otro = (Fraccion) o;

		double valorFraccion = (double) numerador / denominador;
		double valorOtro = (double) otro.getNumerador() / otro.getDenominador();

		if (valorFraccion > valorOtro)
			return 1;
		else if (valorFraccion < valorOtro)
			return -1;
		else
			return 0;

	}
    @Override
    public double doubleValue() {
        return (double) numerador / denominador;
    }

    @Override
    public float floatValue() {
        return (float) numerador / denominador;
    }

    @Override
    public int intValue() {
        return numerador / denominador;
    }

    @Override
    public long longValue() {
        return (long) numerador / denominador;
    }

}