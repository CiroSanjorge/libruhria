package DAO;

import javax.swing.ImageIcon;

/**
 * Interfaz para organizar las consultas
 * @author CIRO SANJORGE, BRIDGITTE MARCIÁS , RAQUEL DOCAMPO
 */
public interface ProductoDAO {

    /**
     * muestra el nombre de un producto dado su id y su tipo
     * @param id id del producto en la base de datos
     * @param tipo 1, 2, 3 (libros, mat_oficina, otros)
     * @return string nombre producto
     */
    String mostrarNombreProducto(int id, int tipo);
     /**
     * muestra el precio de un producto dado su id y su tipo
     * @param id id del producto en la base de datos
     * @param tipo 1, 2, 3 (libros, mat_oficina, otros)
     * @return double precio producto
     */
    double mostrarPrecioProducto(int id, int tipo);
     /**
     * muestra los datos de un producto dado su id y su tipo
     * @param id id del producto en la base de datos
     * @param tipo 1, 2, 3 (libros, mat_oficina, otros)
     * @return string info producto
     */
    String mostrarInfoProducto(int id, int tipo);
     /**
     * muestra la imagen de un producto dado su id y su tipo
     * @param id id del producto en la base de datos
     * @param tipo 1, 2, 3 (libros, mat_oficina, otros)
     * @return ImageIcon icono producto
     */
    ImageIcon mostrarImaxeProducto(int id, int tipo);
    
    
}
