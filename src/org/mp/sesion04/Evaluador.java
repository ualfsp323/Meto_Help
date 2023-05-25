package org.mp.sesion04;

import java.util.StringTokenizer;

public class Evaluador {
	private GenericStack<Integer> pila;
	
	public Evaluador() {
		
	}
	
			public String[] eliminarBlancos(String expresion) {
			    GenericQueue<String> cola = new GenericQueue<String>();
			    String temp = "";

				StringTokenizer st = new StringTokenizer(expresion);
				 while (st.hasMoreTokens()) {
			            String token = st.nextToken();
				       if (!token.equals(" ")) { 
				    	   if (esOperador(token)) {
				            temp += token;
			                cola.enqueue(temp);
				    	   } else {
			                  cola.enqueue(token);	
			                }
				        }
			           
			              
			            }
			        
			      String [] arrayS = new String[cola.getSize()];		
			      
			      for (int i = 0; i < arrayS.length; i++) {
			    	  
						arrayS[i] = cola.dequeue();
					}			      
			      return arrayS;
	}

			public void procesarUnOperador(char op, GenericStack<Integer> operandosPila) {
			    if(op =='+') {
			        int segundoOperando = operandosPila.pop();
			        int primerOperando = operandosPila.pop();
			        int resultado = primerOperando + segundoOperando;
			        operandosPila.push(resultado);
			    	
			    }	
			    
			    if (op=='-')	{
			    	int segundoOperando = operandosPila.pop();
			        int primerOperando = operandosPila.pop();
			        int resultado = primerOperando - segundoOperando;
			        operandosPila.push(resultado);
				}
			    
			    if (op=='*')	{
			    	int segundoOperando = operandosPila.pop();
			        int primerOperando = operandosPila.pop();
			        int resultado = primerOperando* segundoOperando;
			        operandosPila.push(resultado);
				}
			    
			    if (op=='/')	{
			    	int segundoOperando = operandosPila.pop();
			        int primerOperando = operandosPila.pop();
			        if (primerOperando==0 || segundoOperando==0) {
			        	throw new RuntimeException("No es posible una división por cero");
			        }else {
			        int resultado = primerOperando / segundoOperando;
			        operandosPila.push(resultado);
			      }
			    }
			}
   
	public Object evaluarExpresion(String string) {
		GenericStack<Integer> operator   = new GenericStack<Integer>();
		GenericStack<Double> value  = new GenericStack<Double>();

        // Let's create some temparory stacks for operands and operators
		GenericStack<Integer>  tmpOp  =new GenericStack<Integer> ();
	    GenericStack<Double> tmpVal = new GenericStack<Double> ();

        // Enter an arthematic expression
     
        string = "0" + string;
        string = string.replaceAll("-","+-");

        // In the respective stacks store the operators and operands
        String temp = "";
        for (int i = 0;i < string.length();i++){
            char ch = string.charAt(i);
            if (ch == '-')
                temp = "-" + temp;
            else if (ch != '+' &&  ch != '*' && ch != '/')
               temp = temp + ch;
            else{
                value.push(Double.parseDouble(temp));
                operator.push((int)ch);
                temp = "";
            }
        }
        value.push(Double.parseDouble(temp));


        char operators[] = {'/','*','+'};

        for (int i = 0; i < 3; i++){
            boolean it = false;
            while (!operator.isEmpty()){
                int optr = operator.pop();
                double v1 = value.pop();
                double v2 = value.pop();

                if (optr == operators[i]){
                    // if operator matches evaluate and store it in the temporary stack
                    if (i == 0){
                        tmpVal.push(v2 / v1);
                        it = true;
                        break;
                    }
                    else if (i == 1){
                        tmpVal.push(v2 * v1);
                        it = true;
                        break;
                    }
                    else if (i == 2){
                        tmpVal.push(v2 + v1);
                        it = true;
                        break;
                    }
                }
                else{
                    tmpVal.push(v1);
                    value.push(v2);
                    tmpOp.push(optr);
                }
            }
            while (!tmpVal.isEmpty())
                value.push(tmpVal.pop());
            while (!tmpOp.isEmpty())
                operator.push(tmpOp.pop());
            if (it)
                i--;
        }
        return value.pop();
    }

	
	
	public boolean soloDigitos(String expresion) {
	    for (int i = 0; i < expresion.length(); i++) {
	        if (!Character.isDigit(expresion.charAt(i))) {
	            return false;
	        }
	    }
	    return true;
	}

	public boolean esOperador(String token) {
	    return "+-*/".contains(token);
	}
	
}
