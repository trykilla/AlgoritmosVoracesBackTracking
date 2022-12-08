package BackTracking;
/***********************
*
* Nombre de la clase: Main
* Nombre de los autores: H�ctor AlbercaSanchez-Quintanar, Dario Andr�s Fallavollita Figueroa
* Fecha de creaci�n: 20/04/2022
* Version de la clase: 1.0
* Descripci�n de la clase: Tenemos el main, clase principal del programa, en ella se crear� el vector de n�meros disponibles y el
* de 5 ppsiciones para nuestra solucion. Haremos llamado a nuestros metodos de rellenar generar y crear n�mero random. Luego, mostraremos 
* el resultados* y llamaremos a nuestro m�todo backtraking para que encuentre la soluci�n si la hay.
* 
*
************************
*/

public class Main implements Constantes {

	public static void main(String[] args) {
		char[] vectorDisponibles = new char[numElementos];
		char[] vectorSolucion = new char[n];

		int resultado = 0;
		int etapaInicial = 0;

		vectorSolucion = GenerarExpresion.rellenarVector(vectorSolucion);
		vectorDisponibles = GenerarExpresion.generarVector();
		resultado = GenerarExpresion.crearNumeroRandom();

		mostrarResultados(resultado, vectorDisponibles);
		Backtracking b1 = new Backtracking(false);
		b1.backtracking(resultado, etapaInicial, vectorDisponibles, vectorSolucion);
		b1.noSolucion();

	}

	
	public static void mostrarResultados(int resultado, char[] vector) {

		System.out.println("El resultado final debe ser " + resultado);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();
		System.out.print("Digitos y Operadores para la ejecución: [");

		for (int i = 0; i < vector.length - 1; i++) {
			System.out.print(vector[i] + ", ");
		}
		System.out.println(vector[8] + "]");
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Comenzando la búsqueda...");
	}

}
