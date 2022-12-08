package Voraces;

/***********************
*
* Nombre de la clase: Pueblo
* Nombre de los autores: H�ctor AlbercaSanchez-Quintanar, Dario Andr�s Fallavollita Figueroa
* Fecha de creaci�n: 15/04/2022
* Version de la clase: 1.0
* Descripci�n de la clase: Esta clase es la clase pueblo, donde elaboramos los set y get que utilizaremos en nuestra clase main.
* A su vez, creamos el metodo comparator.
* 
*
************************
*/
import java.util.Comparator;

public class Pueblo {
    protected int kilos;
    protected int id;

    public Pueblo(int kilos, int id) {
        this.kilos = kilos;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getKilos() {
        return kilos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKilos(int kilos) {
        this.kilos = kilos;
    }



	@Override
	public String toString() {
		return "Pueblo [kilos=" + kilos + ", id=" + id + "]";
	}
	}

/*************************
 * 
 * Nombre del metodo: KilosComparator
 * Descripcion del metodo: Es un m�todo donde utilizamos un compare. El collecton lo utiliza para hacer una comparacon de los kilos 
 * entre los pueblos para saber cual es mayor. 
 * Llamada de argumentos: dos pueblos para compararlos entre si
 * 
 * ************************/

class KilosComparator implements Comparator<Pueblo> {
	public int compare (Pueblo o, Pueblo p) {
		if (o.getKilos() == p.getKilos()) {
			return 0;
		} else if (o.getKilos() < p.getKilos()) {
			return 1;
		} else {
			return -1;	
		}
}
}
