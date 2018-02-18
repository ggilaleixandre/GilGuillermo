package calculadora;

/**
 *  Calculadora con notación polaca inversa.
 * @author Guillermo
 *
 */

public class RPN {
	/**
	 * Inserta un dato en la pila.
	 * @param nuevo_dato Dato que inserta en la pila.
	 */
	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	/**
	 * Extrae un dato de la pila.
	 * @return Dato que extrae de la pila.
	 */
	public double popPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	/**
	 * Pone un comando a ejecutar por la calculadora.
	 * @param commando Comando a ejecutar.
	 */
	public RPN(String commando) {
		arriba = null;
		this.commando = commando;
	}
	
	/**
	 * Ejercuta la operación de Suma
	 */
	public void suma() {
		b = popPila( );
		a = popPila( );
		pushPila(a + b);
	}
	/**
	 * Ejecuta la operación de Resta
	 */
	public void resta() {
		b = popPila( );
		a = popPila( );
		pushPila(a - b);
	}
	/**
	 * Ejecuta la operación de multiplicación.
	 */
	public void multiplicacion(){
		b = popPila( );
		a = popPila( );
		pushPila(a * b);
	}
	/**
	 * Ejecuta la operación de división.
	 */
	public void division() {
		b = popPila( );
		a = popPila( );
		pushPila(a / b);
	}
	/**
	 * Ejecuta la operación de exponencial.
	 */
	public void exponencial() {
		b = popPila( );
		a = popPila( );
		pushPila(Math.pow(a, b));
	}
	/**
	 * Ejecuta la operación de resto.
	 */
	public void resto() {
		b = popPila( );
		a = popPila( );
		pushPila(a%b);
	}
	/**
	 * Convierte un String en número y lo mete en la pila.
	 * @param temp String a convertir a numero.
	 */
	public void obtenerNumero(String temp) {
		
		// convertir a double y añadir a la pila
		numero = Double.parseDouble(temp);
		pushPila(numero);
		
	}
	
	/**
	 * Ejecuta una de las posibles operaciones.
	 */
	public void operaciones() {
		for(int i = 0; i < commando.length( ); i++) {
			// si es un digito
			if(Character.isDigit(commando.charAt(i))) {
				String temp = "";
				for(int j = 0; (j < 100) && (Character.isDigit(commando.charAt(i)) || (commando.charAt(i) == '.')); j++, i++) {
					temp = temp + String.valueOf(commando.charAt(i));
					this.obtenerNumero(temp);
				}
			} else if(commando.charAt(i) == '+') {
				this.suma();
			} else if(commando.charAt(i) == '-') {
				this.resta();
			} else if(commando.charAt(i) == '*') {
				this.multiplicacion();
			} else if(commando.charAt(i) == '/') {
				this.division();
			}else if(commando.charAt(i) == '^') {
				this.exponencial();
			}else if(commando.charAt(i) == '%') {
				this.resto();
			}else if(commando.charAt(i) != ' ') {
				throw new IllegalArgumentException( );
			}
		}
	}
	/**
	 * Devuelve el resultado de la operación.
	 * @return Resultado de la operación.
	 */
	public double resultado( ) {

		this.operaciones();
		double val = popPila( );
		if(arriba != null) {
			throw new IllegalArgumentException( );
		}
		return val;
	}

	private String commando;
	private NodoPila arriba;
	private double a, b, numero;
}