package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlmacenDAO {
    private final Connection conn;

    public AlmacenDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean insertarAlmacen(Almacen almacen) {
        String sql = "INSERT INTO almacenes (nombre, tipo, ubicacion) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, almacen.getNombre());
            ps.setString(2, almacen.getTipo());
            ps.setString(3, almacen.getUbicacion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar almacén: " + e.getMessage());
            return false;
        }
    }
}
