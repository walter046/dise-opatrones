package reportes;

import conexion.ConexionBD;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ReporteProductosBuilder implements ReporteBuilder {
    private DefaultTableModel modelo;

    @Override
    public void construirEncabezado() {
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Stock");
        modelo.addColumn("Almacén");
    }

    @Override
    public void construirContenido() {
        String sql = "SELECT p.id, p.nombre, p.descripcion, p.stock, a.nombre AS almacen " +
                     "FROM productos p INNER JOIN almacenes a ON p.id_almacen = a.id";

        try (Connection conn = ConexionBD.getInstancia().getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] fila = {
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("stock"),
                        rs.getString("almacen")
                };
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            System.out.println("Error al generar contenido del reporte: " + e.getMessage());
        }
    }

    @Override
    public DefaultTableModel obtenerReporte() {
        return modelo;
    }
}
