package modelo;

import conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;


public class ProductoDAO {

    // Insertar nuevo producto
public boolean agregarProducto(Producto p) {
    String sql = "INSERT INTO productos (nombre, descripcion, stock, id_almacen) VALUES (?, ?, ?, ?)";
    try (Connection con = ConexionBD.getInstancia().getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getDescripcion());
        ps.setInt(3, p.getStock());
        ps.setInt(4, p.getIdAlmacen());

        ps.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Error al agregar producto: " + e.getMessage());
        return false;
    }
}


    // Listar todos los productos
    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection con = ConexionBD.getInstancia().getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setStock(rs.getInt("stock"));
                p.setIdAlmacen(rs.getInt("id_almacen"));

                productos.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
        }

        return productos;
    }

    // Actualizar stock de producto (entrada o salida)
    public boolean actualizarStock(int idProducto, int nuevoStock) {
        String sql = "UPDATE productos SET stock = ? WHERE id = ?";
        try (Connection con = ConexionBD.getInstancia().getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nuevoStock);
            ps.setInt(2, idProducto);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar stock: " + e.getMessage());
            return false;
        }
    }

    // Registrar movimiento de inventario
    public boolean registrarMovimiento(int idProducto, String tipo, int cantidad) {
        String sql = "INSERT INTO inventario_movimientos (id_producto, tipo, cantidad) VALUES (?, ?, ?)";
        try (Connection con = ConexionBD.getInstancia().getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProducto);
            ps.setString(2, tipo);
            ps.setInt(3, cantidad);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar movimiento: " + e.getMessage());
            return false;
        }
    }

    // Obtener producto por ID
    public Producto buscarPorId(int id) {
        String sql = "SELECT * FROM productos WHERE id = ?";
        try (Connection con = ConexionBD.getInstancia().getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setStock(rs.getInt("stock"));
                p.setIdAlmacen(rs.getInt("id_almacen"));
                return p;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }

        return null;
    }
}
