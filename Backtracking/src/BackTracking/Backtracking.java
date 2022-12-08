package BackTracking;

/***********************
*
* Nombre de la clase: Bactracking
* Nombre de los autores: H�ctor AlbercaSanchez-Quintanar, Dario Andr�s Fallavollita Figueroa
* Fecha de creaci�n: 20/04/2022
* Version de la clase: 1.0
* Descripci�n de la clase: Esta clase contiene el m�todo de backtraking, a dicho m�todo le pasamos unos par�metros
* una ves tengamos los descendientes, vamos comprobando, cambiando las posiciones que hay con todos los n�meros que tenemos
*  
* 
*
************************
*/

public class Backtracking {
	private boolean enc = false;

	public Backtracking(boolean enc) {

		this.enc = enc;
	}

	public void backtracking(int resultado, int etapa, char[] vectorDisponibles, char[] estado) {
		char[] descent;

		if (etapa == 5 && !enc) {
			if (enc = esSolucion(resultado, etapa, estado)) {
				procesarSolucion(resultado, estado);

			}
		} else if (!enc && etapa < estado.length) {
			descent = generarDescendientes(vectorDisponibles, etapa);

			for (int i = 0; i < descent.length; i++) {
				estado[etapa] = descent[i];
				backtracking(resultado, etapa + 1, vectorDisponibles, estado);

			}
		}
	}

	/*************************
	 * 
	 * Nombre del metodo: generarDescendientes
	 * Descripcion del metodo: En el siguiente m�todo llenaremos nuestro vector solucion de 5 posiciones con el vector generado 
	 * el cual posee 7 n�meros y 2 operadores aleatorios. En toda etapa distinta a 2 la llenaremos con n�meros del 0 al 9, y 
	 * la etapa dos con nuestro operador.
	 * Llamada de argumentos: utilizamos el vector disponible y las etapas
	 * 
	 * ************************/
	
	public static char[] generarDescendientes(char[] vectorDisponibles, int etapa) {

		char[] c;

		String descendientes = "";
		for (char i : vectorDisponibles) {
			descendientes += i;
		}

		if (etapa != 2) {
			descendientes = descendientes.substring(0, 7);

		} else {
			descendientes = descendientes.substring(7, 9);

		}

		c = descendientes.toCharArray();

		return c;

	}

	
	public static void procesarSolucion(int resultado, char[] estado) {

		String expresion = "";
		for (int i = 0; i < estado.length; i++) {
			expresion += estado[i] + " ";
		}

		expresion += " = " + resultado;

		System.out.println("El resultado esperado era " + resultado);
		System.out.println("La expresion generada es " + expresion);
	}

	public void noSolucion() {
		if (!enc) {
			System.out.println("No hay soluci�n con estos par�metros.");
		}
	}

	/*************************
	 * 
	 * Nombre del metodo: esSolucion
	 * Descripcion del metodo: mediante el siguiente m�todo sabremos si hay soluci�n. Establecemos los operandos izquierda(etapa 0 y 1) 
	 * y derecha (etapa 3 y 4) y dependiendo de que operador tengamos haremos la operaci�n respectiva. 
	 * Llamada de argumentos: utilizamos el resultado generado, la etapa en la que nos encontramos y el estado.
	 * 
	 * ************************/
	
	public static boolean esSolucion(int resultado, int etapa, char[] estado) {

		int operacion = 0;
		boolean enc = false;
		int izq = ((Character.getNumericValue(estado[0])) * 10) + (Character.getNumericValue(estado[1]));
		int der = ((Character.getNumericValue(estado[3])) * 10) + (Character.getNumericValue(estado[4]));

		switch (estado[2]) {
		case '+':
			operacion = (izq) + (der);
			break;

		case '-':
			operacion = (izq) - (der);
			break;

		case '/':
			if (der != 0) {
				operacion = (izq) / (der);
			}
			break;

		case '*':
			operacion = (izq) * (der);
			break;
		}

		if (operacion == resultado) {
			enc = true;
		}

		return enc;
	}

}
