package calculadora;


public class RPN {
	
	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	public double popPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	public RPN(String commando) {
		arriba = null;
		this.commando = commando;
	}
	
	public void suma() {
		b = popPila( );
		a = popPila( );
		pushPila(a + b);
	}
	public void resta() {
		b = popPila( );
		a = popPila( );
		pushPila(a - b);
	}
	public void multiplicacion(){
		b = popPila( );
		a = popPila( );
		pushPila(a * b);
	}
	public void division() {
		b = popPila( );
		a = popPila( );
		pushPila(a / b);
	}
	public void exponencial() {
		b = popPila( );
		a = popPila( );
		pushPila(Math.pow(a, b));
	}
	
	public void resto() {
		b = popPila( );
		a = popPila( );
		pushPila(a%b);
	}
	
	public void obtenerNumero(String temp) {
		
		// convertir a double y añadir a la pila
		numero = Double.parseDouble(temp);
		pushPila(numero);
		
	}
	
	
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