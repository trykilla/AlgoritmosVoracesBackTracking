package Voraces;

import java.io.*;
import java.util.*;

/***********************
*
* Nombre de la clase: Fichero
* Nombre de los autores: H�ctor AlbercaSanchez-Quintanar, Dario Andr�s Fallavollita Figueroa
* Fecha de creaci�n: 15/04/2022
* Version de la clase: 1.0
* Descripci�n de la clase: nos servir� para escribir y leer ficheros, que lo haremos mediante arraylist, controlando sus excepciones.
* En este caso usamos el archivo suministros.txt el cual se nos ha administrado.
*
************************
*/

public class Fichero {

    public static boolean EscribirFichero(String cadena) {
        boolean escrito = false;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("VoracesBacktracking/Resources/suministros.txt");
            pw = new PrintWriter(fichero);

            pw.println(cadena);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (null != fichero)
                    escrito = true;
                fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return escrito;

    }

    public static ArrayList<Integer> LeerFichero() throws IOException {
        ArrayList<Integer> capacidades = new ArrayList<Integer>();
        BufferedReader br = null;
        File f = null;
        FileReader fr = null;
        try {
            f = new File("VoracesBacktracking/Resources/suministros.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                while (st.hasMoreTokens())
                    capacidades.add(Integer.parseInt(st.nextToken()));
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return capacidades;
    }

}
