package controlador;

import modelo.Producto;
import modelo.ProductoDAO;
import vista.InventarioForm;
import javax.swing.*;

public class InventarioControlador {
    private InventarioForm vista;
    private ProductoDAO productoDAO;

    public InventarioControlador(InventarioForm vista) {
        this.vista = vista;
        this.productoDAO = new ProductoDAO();

        // Asignar evento al botón
        vista.jbtnagregarPro.addActionListener(e -> guardarProducto());
    }

    private void guardarProducto() {
        try {
            String nombre = vista.jtxtNombrepro.getText().trim();
            String descripcion = vista.jtxtdescrpcionPro.getText().trim();
            int stock = Integer.parseInt(vista.jtxtcantidadPro.getText().trim());

            if (nombre.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Completa todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Producto p = new Producto();
            p.setNombre(nombre);
            p.setDescripcion(descripcion);
            p.setStock(stock);
            p.setIdAlmacen(1); // Ajusta según tu base de datos

            boolean exito = productoDAO.agregarProducto(p);

            if (exito) {
                productoDAO.registrarMovimiento(p.getId(), "ENTRADA", stock);
                JOptionPane.showMessageDialog(vista, "Producto guardado con éxito");
                limpiarFormulario();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al guardar el producto", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "El stock debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        vista.jtxtNombrepro.setText("");
        vista.jtxtdescrpcionPro.setText("");
        vista.jtxtcantidadPro.setText("");
    }
}

