package DAO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author CIRO SANJORGE, BRIDGITTE MARCIÁS , RAQUEL DOCAMPO
 */
public class ProductoDAOImplements extends ConexionBD implements ProductoDAO {

    @Override
    public String mostrarNombreProducto(int id, int tipo) {
        String output = "[nombre]";
        try {
            this.connect();
            PreparedStatement ps = this.conexion.prepareStatement("Select NOMBRE from " + comprobaTipo(tipo) + " where ID = " + id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                output = rs.getString(1);
            }

        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(ProductoDAOImplements.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                this.closeConnect();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAOImplements.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return output;
    }

    @Override
    public double mostrarPrecioProducto(int id, int tipo) {
        double output = 0;
        try {
            this.connect();
            PreparedStatement ps = this.conexion.prepareStatement("Select precio from " + comprobaTipo(tipo) + " where id =" + id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                output = rs.getInt(1);

            }

        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(ProductoDAOImplements.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                this.closeConnect();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAOImplements.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return output;
    }

    @Override
    public String mostrarInfoProducto(int id, int tipo) {
        String output = "[info]";
        try {
            this.connect();
            PreparedStatement ps = this.conexion.prepareStatement("Select * from " + comprobaTipo(tipo) + " where id =" + id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (tipo == 1) {
                    output = "NOMBRE: " + rs.getString(2)
                            + "\nAUTOR: " + rs.getString(3)
                            + "\nFECHA PUBLICACION: " + rs.getString(4)
                            + "\nEDITORIAL: " + rs.getString(5)
                            + "\nGENERO: " + rs.getString(6);
                } else {
                    output = "NOMBRE: " + rs.getString(2) + "\nMARCA: " + rs.getString(4);
                }

            }
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(ProductoDAOImplements.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                this.closeConnect();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAOImplements.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return output;
    }

    @Override
    public ImageIcon mostrarImaxeProducto(int id, int tipo) {
        byte[] imgData = null;
        ImageIcon icon = null;
        try {
            this.connect();
            PreparedStatement ps = this.conexion.prepareStatement("Select imagen from " + comprobaTipo(tipo) + " where id =" + id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blob img = rs.getBlob(1);
                imgData = img.getBytes(1, (int) img.length());
                BufferedImage imag = ImageIO.read(new ByteArrayInputStream(imgData));
                icon = new ImageIcon(imag);
            }
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(ProductoDAOImplements.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                this.closeConnect();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAOImplements.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return icon;
    }
    private String comprobaTipo(int tipo) {
        switch (tipo) {
            case 1:
                return "libros";
            case 2:
                return "material_oficina";
            default:
                return "otros";
        }
    }

}
