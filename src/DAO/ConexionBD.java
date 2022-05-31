package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Conexión a la base de datos
 * 
 * @author CIRO SANJORGE, BRIDGITTE MARCIÁS , RAQUEL DOCAMPO
 */
public class ConexionBD {
 protected Connection conexion;
    private final static String DB_URL = "jdbc:mysql://localhost:3306/libreria";
    private final static String USER = "root";
    private final static String PASSWD = "";
    
    /**
     * Abre la conexion
     * @throws Exception 
     */
    public void connect() throws Exception{
        try{
           conexion = DriverManager.getConnection(DB_URL, USER, PASSWD);
            
        }catch(SQLException e){
            throw e;
        }
    }
    /**
     * Cierra la conexión;
     * @throws SQLException 
     */
    public void closeConnect() throws SQLException{
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}
