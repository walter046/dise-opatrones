package modelo;

import modelo.Pedido;
import conexion.ConexionBD;
import java.sql.*;

public class PedidoDAO {
    public boolean guardarPedido(Pedido p) {
        String sqlPedido = "INSERT INTO pedidos (estado, cliente_nombre) VALUES (?, ?)";
        String sqlDetalle = "INSERT INTO detalle_pedidos (id_pedido, id_producto, cantidad) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.getInstancia().getConexion()) {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getEstado());
            ps.setString(2, p.getClienteNombre());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idPedido = rs.getInt(1);

                for (DetallePedido d : p.getDetalles()) {
                    PreparedStatement psDet = con.prepareStatement(sqlDetalle);
                    psDet.setInt(1, idPedido);
                    psDet.setInt(2, d.getIdProducto());
                    psDet.setInt(3, d.getCantidad());
                    psDet.executeUpdate();
                }
            }
            con.commit();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar pedido: " + e.getMessage());
            return false;
        }
    }
}
