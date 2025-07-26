import controlador.PedidoControlador;
import vista.PedidoForm;

public class TestPedidos {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            PedidoForm vista = new PedidoForm();
            new PedidoControlador(vista);
            vista.setVisible(true);
        });
    }
}
