package org.mp.sesion02;




public abstract class MatrizGenerica<E extends Number> {

	protected abstract E sumar(E o1, E o2);

	protected abstract E multiplicar(E o1, E o2);

	public E cero() {
		return null;

	}

	public E[][] multiplicarMatrices(E[][] matriz1, E[][] matriz2) {
		int filasMatriz1 = matriz1.length;
		int columnasMatriz1 = matriz1[0].length;
		int filasMatriz2 = matriz2.length;
		int columnasMatriz2 = matriz2[0].length; 
		if (filasMatriz1 != columnasMatriz2 || columnasMatriz1 != filasMatriz2)
	        {
				throw new RuntimeException("No coinciden las columnas de la primera matriz con las filas de la segunda");

	        }
		 int[][] c = new int[matriz1.length][matriz2[0].length];
			E[][] resultado = (E[][]) new Number[matriz1.length][matriz2[0].length];

		 for (int i = 0; i < filasMatriz1; i++) {
			for (int j = 0; j < columnasMatriz2; j++) {
				resultado[i][j] = cero();

			}
		}
		        for (int i = 0; i < matriz1.length; i++) {
		            for (int j = 0; j < matriz2[0].length; j++) {
		                for (int k = 0; k < matriz1[0].length; k++) {
		                
				                resultado[i][j] = sumar(resultado[i][j], multiplicar(matriz1[i][k], matriz2[k][j]));

		    			    	
		                }
		            }
		        }
		        
		    
		    /**
		     * si no se cumple la condición se retorna una matriz vacía
		     */
		    return resultado;
		}
		 
		 
	

	@SuppressWarnings({ "removal", "unchecked" })
	public E[][] sumarMatrices(E[][] matriz1, E[][] matriz2) {
		int filasMatriz1 = matriz1.length;
		int columnasMatriz1 = matriz1[0].length;
		int filasMatriz2 = matriz2.length;
		int columnasMatriz2 = matriz2[0].length;
		   if (filasMatriz1 != filasMatriz2 || columnasMatriz1 != columnasMatriz2)
	        {
				throw new RuntimeException("Las matrices no tienen el mismo tamaño");

	        }
		   if (filasMatriz1 != columnasMatriz2 || columnasMatriz1 != filasMatriz2)
	        {
				throw new RuntimeException("No coinciden las columnas de la primera matriz con las filas de la segunda");

	        }
		E[][] resultado = (E[][]) new Number[filasMatriz1][columnasMatriz2];

		for (int i = 0; i < filasMatriz1; i++) {
			for (int j = 0; j < columnasMatriz2; j++) {
				resultado[i][j] = (E) new Integer(0);
			}
		}

		for (int i = 0; i < filasMatriz1; i++) {
			for (int j = 0; j < columnasMatriz2; j++) {
					
				
				if (matriz1[i][j] instanceof Fraccion ) {
					resultado[i][j] = (E) ( ((Fraccion) matriz1[i][j]).sumar( (Fraccion) matriz2[i][j]));
			    	}else {
						resultado[i][j] = (E) new Integer((Integer) sumar(matriz1[i][j], matriz2[i][j]));

			    	}
				}
			}
		

		return resultado;
	}
}
