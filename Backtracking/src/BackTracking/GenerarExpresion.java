package BackTracking;


import java.util.ArrayList;
import java.util.Collections;


/***********************
*
* Nombre de la clase: GenerarExpresi�n
* Nombre de los autores: H�ctor AlbercaSanchez-Quintanar, Dario Andr�s Fallavollita Figueroa
* Fecha de creaci�n: 15/04/2022
* Version de la clase: 1.0
* Descripci�n de la clase: tenemos la clase GenerarExpresi�n, donde crearemos los arraylist y vectores con nuestros numeros signos y elementos
* necesarios. Haremos uso del shuffle, donde sorteara nuestro vector de n�meros y signos para seleccionar el que utilizaremos en nuestro vector
* final. Tambien pasaremos a est�tico nuestro array.
* 
*
************************
*/

public class GenerarExpresion implements Constantes {

	public static char[] generarVector() {

		ArrayList<Character> nums = new ArrayList<Character>();
		ArrayList<Character> signos = new ArrayList<Character>();
		ArrayList<Character> vectorFinal = new ArrayList<Character>();
		char[] vectorCharFinal = new char[numElementos];

		signos.add('+');
		signos.add('-');
		signos.add('*');
		signos.add('/');

		for (int i = 0; i < numElementos; i++) {
			nums.add((char) (i + '0'));
		}

		Collections.shuffle(nums);
		Collections.shuffle(signos);

		for (int i = 0; i < numNumeros; i++) {
			vectorFinal.add(nums.get(i));
		}

		for (int i = 0; i < numSignos; i++) {
			vectorFinal.add(signos.get(i));
		}

		for (int i = 0; i < vectorCharFinal.length; i++) {
			vectorCharFinal[i] = vectorFinal.get(i);
		}

		return vectorCharFinal;

	}

	public static char[] rellenarVector(char[] vectorSolucion) {

		for (int i = 0; i < vectorSolucion.length; i++) {
			vectorSolucion[i] = '_';

		} 
		return vectorSolucion;
	}

	public static int crearNumeroRandom() {

		int numero = 0;
		numero = (int) (Math.random() * 109) - 10;

		return numero;
	}
}
