package org.mp.sesion01;


public class Carta implements Comparable<Object> {

	private String palo;
	private int numero;
	private int valor;
    public static final int LIMITE_PALO=12;


	public Carta(String palo ,int valor, int numero ) {
		super();
		this.palo = new String(palo);
		this.numero = numero;
		

	}
	public Carta(String palo ,int numero ) {
		super();
		this.palo = new String(palo);
		this.numero = numero;
		switch (palo) {
		case "O":
			this.valor=numero;
			break;
		case "C":
			this.valor=numero+12;
			break;
		case "E":
			this.valor=numero+24;
			break;
		case "B":
			this.valor=numero+36;
			break;
		default:
			break;
		};


	}
	
	public Carta(Carta c) {
		super();
		this.palo = new String(c.palo);
        this.numero = c.numero;
		switch (palo) {
		case "O":
			this.valor=c.numero;
			break;
		case "C":
			this.valor=c.numero+12;
			break;
		case "E":
			this.valor=c.numero+24;
			break;
		case "B":
			this.valor=c.numero+36;
			break;
		default:
			break;
		};


	}

	public int getNumero() {
		return numero;
	}
	public int getValor() {
		return valor;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo){
		this.palo=new String(palo);
	}
	public void setNumero(int numero){
		this.numero=numero;
	}
	public void setValor(int valor){
		this.valor=valor;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Carta copy = (Carta) obj;
		if (palo == copy.palo)
			return false;
		if (numero != copy.numero)
			return false;
		return true;
	}
	
	public int compareTo(Object obj) {
			Carta copy = (Carta) obj;

			if (valor==copy.valor) {
				return 0;
			}
			else if ( valor < copy.valor ) {
				
				return -1;
			}
			else
				return 1;
			
		
	}
}