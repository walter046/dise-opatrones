package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD instancia;
    private Connection conexion;

    private final String URL = "jdbc:mysql://localhost:3306/almacenBD";
    private final String USER = "root"; 
    private final String PASSWORD = ""; 

    private ConexionBD() {
        conectar();
    }

    private void conectar() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();  // ← vuelve a conectar si está cerrada
            }
        } catch (SQLException e) {
            System.out.println("Error al comprobar la conexión: " + e.getMessage());
            conectar(); // ← reconecta si hay error
        }
        return conexion;
    }
}
