package org.mp.sesion05;


public class Baraja {

	/** The nombre baraja. */
	private String nombreBaraja;
	
	/** The cartas. */
	private Carta[] cartas;

	/**
	 * Instantiates a new baraja.
	 *
	 * @param nombreBaraja the nombre baraja
	 * @param cartas the cartas
	 */
	public Baraja(String nombreBaraja, Carta[] cartas) {
		super();
		this.nombreBaraja = new String(nombreBaraja);
		if (cartas != null) {
			this.cartas = new Carta[cartas.length];
			for (int i = 0; i < this.cartas.length; i++) {
				this.cartas[i] = new Carta(cartas[i]);
			}
		}
	}

	/**
	 * Instantiates a new baraja.
	 *
	 * @param B the b
	 */
	public Baraja(Baraja B) {
		super();
		this.nombreBaraja = new String(B.nombreBaraja);
		if (B.cartas != null) {
			this.cartas = new Carta[B.cartas.length];
			for (int i = 0; i < this.cartas.length; i++) {
				this.cartas[i] = new Carta(B.cartas[i]);
			}
		}

	}

	/**
	 * Gets the cartas.
	 *
	 * @return the cartas
	 */
	public Carta[] getCartas() {
		return cartas;
	}


	/**
	 * Insercion.
	 *
	 * @param cartas the cartas
	 */
	public void insercion(Carta[] cartas) {
		String[] palos = { "O", "C", "E", "B" };

		// Recorro los palos
		for (int i = 0; i < palos.length; i++) {

			// Recorro los numeros
			for (int j = 0; j < 12; j++) {
				if (!(j == 7 || j == 8)) {
					if (j >= 9) {
						// Solo para la sota, caballo y rey
						cartas[((i * (Carta.LIMITE_PALO - 2)) + (j - 2))] = new Carta(palos[i], j + 1);
					} else {
						// Para los casos de 1 a 7
						cartas[((i * (Carta.LIMITE_PALO - 2)) + j)] = new Carta(palos[i], j + 1);
					}

				}
			}

		}

	}

}