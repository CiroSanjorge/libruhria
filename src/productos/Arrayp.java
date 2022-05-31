package productos;

import java.util.ArrayList;

/**
 *Clase para gestionar el array de la cesta
 * @author CIRO SANJORGE, BRIDGITTE MARCIÁS , RAQUEL DOCAMPO
 */
public class Arrayp {
/**
 * cesta
 */
    public static ArrayList<Producto> cesta = new ArrayList();
/**
 * muestra los items de la cesta
 * @return string con los datos de cada producto
 */
    public static String mostrarCesta() {
        String output = "";
        for (Producto producto : cesta) {
            output += producto.toString() + "\n";
        }

        return output;
    }

}
