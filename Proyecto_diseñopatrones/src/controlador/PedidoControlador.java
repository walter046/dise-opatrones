package controlador;

import modelo.Producto;
import modelo.ProductoDAO;
import modelo.DetallePedido;
import modelo.PedidoDAO;
import modelo.EstadoPedido;
import modelo.Pedido;
import vista.PedidoForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PedidoControlador {
    private final PedidoForm vista;
    private Pedido pedidoActual;
    private final PedidoDAO pedidoDAO;

    public PedidoControlador(PedidoForm vista) {
        this.vista = vista;
        this.pedidoDAO = new PedidoDAO();
        this.vista.setVisible(true);
        this.vista.agregarGuardarListener(new GuardarListener());
        this.vista.agregarClonarListener(new ClonarListener());
        this.vista.agregarVerEstadoListener(new VerEstadoListener());

        cargarProductosDesdeBD();
    }

    private void cargarProductosDesdeBD() {
        ProductoDAO productoDAO = new ProductoDAO();
        for (Producto p : productoDAO.listarProductos()) {
            vista.agregarProducto(p.getNombre());
        }
    }

class GuardarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreProducto = vista.getProducto();
        String cliente = vista.getCliente();
        int cantidad;

        try {
            cantidad = vista.getCantidad();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Cantidad inválida. Ingrese un número entero.");
            return;
        }

        if (nombreProducto == null || nombreProducto.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un producto.");
            return;
        }

        if (cliente == null || cliente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Debe ingresar un nombre de cliente.");
            return;
        }

        ProductoDAO productoDAO = new ProductoDAO();
        Producto productoSeleccionado = null;
        for (Producto p : productoDAO.listarProductos()) {
            if (p.getNombre().equals(nombreProducto)) {
                productoSeleccionado = p;
                break;
            }
        }

        if (productoSeleccionado == null) {
            JOptionPane.showMessageDialog(vista, "Producto no encontrado.");
            return;
        }

        DetallePedido detalle = new DetallePedido(productoSeleccionado.getId(), cantidad);
        pedidoActual = new Pedido(cliente, productoSeleccionado.getId(), cantidad); // CORREGIDO
        pedidoActual.agregarDetalle(detalle);

        boolean exito = pedidoDAO.guardarPedido(pedidoActual);
        if (exito) {
            vista.agregarTextoArea("✅ Pedido guardado: " + nombreProducto + " x " + cantidad + "\n");
            vista.limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "❌ Error al guardar el pedido.");
        }
    }
}


    class ClonarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (pedidoActual == null) {
                JOptionPane.showMessageDialog(vista, "No hay pedido para clonar.");
                return;
            }

            Pedido clon = pedidoActual.clone();
            boolean exito = pedidoDAO.guardarPedido(clon);
            if (exito) {
                vista.agregarTextoArea("📋 Pedido clonado: " + clon + "\n");
            } else {
                JOptionPane.showMessageDialog(vista, "❌ Error al clonar el pedido.");
            }
        }
    }

    class VerEstadoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (pedidoActual == null) {
                JOptionPane.showMessageDialog(vista, "No hay pedido registrado.");
                return;
            }

            String estado = pedidoActual.getEstado();
            vista.agregarTextoArea("🔎 Estado actual del pedido: " + estado + "\n");
        }
    }
}
