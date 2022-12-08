package Voraces;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/***********************
 *
 * Nombre de la clase: Main Nombre de los autores: H�ctor
 * AlbercaSanchez-Quintanar, Dario Andr�s Fallavollita Figueroa Fecha de
 * creaci�n: 15/04/2022 Version de la clase: 1.0 Descripci�n de la clase: Esta
 * clase es la clase principal del programa, definimos nuestras variables, como
 * tambien las rellenamos. Escribimos del fichero y escribimos en el fichero,
 * para escribirlo lo pasamos a cadena. Hacemos las impresiones, y hacemos el
 * uso del sort y el metodo de voraz
 * 
 * 
 ************************
 */
public class Main implements Constantes {
	
	final static Scanner sn = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> kilosPoblados = new ArrayList<Integer>();
		ArrayList<Pueblo> pueblos = new ArrayList<Pueblo>();
		int nPoblados;
		int kilosRecoger;
		int mPoblados;
		int pKilos;
		int rPeso;

		System.out.println("Introduce el numero de poblados: ");
		nPoblados = sn.nextInt();
		int[] kilos = new int[nPoblados];

		mPoblados = crearNumeroRandom(nPoblados);
		
		System.out.println("Introduzca el peso máximo a crear de kilos: ");
		pKilos = sn.nextInt();
		kilosRecoger = mPoblados * (pKilos / 2);
		rPeso = crearNumeroRandom(kilosRecoger);
		kilos = Vectores.crearVectorRandom(nPoblados, pKilos);

		String cadena = "";
		cadena = Vectores.creaString(kilos);
		Fichero.EscribirFichero(cadena);
		kilosPoblados = Fichero.LeerFichero();

		pueblos = anadirPueblos(pueblos, kilosPoblados);
		mostrarInicio(nPoblados, mPoblados, rPeso, kilosPoblados, pueblos);
		voraz(pueblos, mPoblados, rPeso);

	}

	public static ArrayList<Pueblo> anadirPueblos(ArrayList<Pueblo> pueblos, ArrayList<Integer> kilosPoblados) {
		for (int i = 0; i < kilosPoblados.size(); i++) {
			pueblos.add(new Pueblo(kilosPoblados.get(i), i));
		}
		return pueblos;
	}

	public static void mostrarInicio(int nPoblados, int mPoblados, int rPeso, ArrayList<Integer> kilosPoblados,
			ArrayList<Pueblo> pueblos) {
		System.out.println("Total Poblados: " + nPoblados);
		System.out.println("Número máximo de poblados a visitar en un día: " + mPoblados);
		System.out.println("Peso que soporta el trineo: " + rPeso);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------");
		int cont = 0;
		System.out.println("Kilos de los poblados a visitar:");
		System.out.print("[");
		for (int i : kilosPoblados) {
			System.out.print(cont+": "+i + "kg, ");
			cont++;
		}
		System.out.print("]\n");
		Collections.sort(pueblos, new KilosComparator());
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------");
		System.out.println("La ruta a seguir es: ");
	}

	public static int crearNumeroRandom(int ls) {

		int numero = 0;
		Random rand = new Random();
		numero = rand.nextInt(ls + 1);

		return numero;
	}

	/*************************
	 * 
	 * Nombre del metodo: Voraz Descripcion del metodo: el m�todo nos ayudar� a
	 * calcular el camino que debe recorrer el trineo, maximizar el n�mero de
	 * suministros que puede obtener minimizando el n�mero de poblados a visitar y
	 * considerando que su trineo soporta un peso m�ximo de R. Llamada de
	 * argumentos: el array de los pueblos posibles, y las variables m, n�mero
	 * maximo de los pueblos que se pueden recorrer y r, el peso m�ximo que soporta
	 * el trineo
	 * 
	 ************************/

	public static void voraz(ArrayList<Pueblo> posibles, int m, int r) {

		int sumaKilos = 0;

		int aux;
		int i = 0;
		int contM = 0;
		while (sumaKilos < r && i != posibles.size() && contM < m) {

			aux = sumaKilos + posibles.get(i).getKilos();

			if (aux <= r && posibles.get(i).getKilos() != 0) {
				sumaKilos += posibles.get(i).getKilos();
				contM++;
				System.out.println("Pueblo: " + posibles.get(i).getId() + " Kilos: " + posibles.get(i).getKilos());
			}
			aux = 0;
			i++;

		}
		System.out.println();
		System.out.println("Kilos de comida recogidos: " + sumaKilos + ", Poblados Visitados: " + contM);
	}

}
