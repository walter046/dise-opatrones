package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PedidoForm extends JFrame {
    private JComboBox<String> comboProducto;
    private JTextField txtCantidad;
    private JTextField txtCliente;
    private JTextArea textArea;
    private JButton btnGuardar;
    private JButton btnClonar;
    private JButton btnVerEstado;

    public PedidoForm() {
        setTitle("Gestión de Pedidos");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel campos = new JPanel(new GridLayout(5, 2, 10, 10));
        campos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        campos.add(new JLabel("Cliente:"));
        txtCliente = new JTextField();
        campos.add(txtCliente);

        campos.add(new JLabel("Producto:"));
        comboProducto = new JComboBox<>();
        campos.add(comboProducto);

        campos.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        campos.add(txtCantidad);

        btnGuardar = new JButton("Guardar Pedido");
        campos.add(btnGuardar);

        btnClonar = new JButton("Clonar Pedido");
        campos.add(btnClonar);

        btnVerEstado = new JButton("Ver Estado");
        campos.add(btnVerEstado);

        panel.add(campos, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        panel.add(scroll, BorderLayout.CENTER);

        add(panel);
    }

    // Métodos para el controlador

    public String getCliente() {
        return txtCliente.getText().trim();
    }

    public String getProducto() {
        return comboProducto.getSelectedItem().toString();
    }

    public int getCantidad() {
        return Integer.parseInt(txtCantidad.getText().trim());
    }

    public void limpiarCampos() {
        txtCliente.setText("");
        txtCantidad.setText("");
    }

    public void agregarTextoArea(String texto) {
        textArea.append(texto + "\n");
    }

    public void agregarProducto(String nombre) {
        comboProducto.addItem(nombre);
    }

    // Listeners
    public void agregarGuardarListener(ActionListener listener) {
        btnGuardar.addActionListener(listener);
    }

    public void agregarClonarListener(ActionListener listener) {
        btnClonar.addActionListener(listener);
    }

    public void agregarVerEstadoListener(ActionListener listener) {
        btnVerEstado.addActionListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
