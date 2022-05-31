package productos;

import javax.swing.JOptionPane;

/**
 *
 * @author a21cirosc
 */
public class Producto {

    private String nombre;
    private double precio;
    private int cantidadProductos;

    public Producto(String nombre, double precio, int cantidadProductos) {
         this.nombre = nombre;
        this.precio = precio;
        this.cantidadProductos = cantidadProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    @Override
    public String toString() {
        return "" + "NOMBRE: " + nombre + ",                      PRECIO: " + precio + ",                         CANTIDAD: " + cantidadProductos;
    }
}
    