package Voraces;


/***********************
*
* Nombre de la clase: Vectores
* Nombre de los autores: H�ctor AlbercaSanchez-Quintanar, Dario Andr�s Fallavollita Figueroa
* Fecha de creaci�n: 15/04/2022
* Version de la clase: 1.0
* Descripci�n de la clase: esta clase esta conformada por dos m�todos, uno donde crearemos nuestro vector random o numero random 
* para nuestras variables de pueblos, y otro donde creamos un string por medio de un vector.
* 
*
************************
*/
public class Vectores {
	public static int[] crearVectorRandom(int n, int ls) {
		int[] vector = new int[n];
		for (int i = 0; i < vector.length; i++) {

			vector[i] = Main.crearNumeroRandom(ls);
		}
		return vector;
	}

	public static String creaString(int[] vector) {

		String cadena = "";
		int i = 0;
		while (i < vector.length - 1) {
			cadena += vector[i] + ",";
			i++;
		}
		cadena += vector[i];

		return cadena;
	}
}
