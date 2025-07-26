package controlador;

import vista.AlmacenForm;
import modelo.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AlmacenControlador {
    private final AlmacenForm vista;
    private final AlmacenDAO dao;

    public AlmacenControlador(AlmacenForm vista, Connection conn) {
        this.vista = vista;
        this.dao = new AlmacenDAO(conn);
        this.vista.btnCrearAlmacen.addActionListener(new CrearAlmacenListener());
    }

    class CrearAlmacenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = vista.jtxtNombre.getText();
            String ubicacion = vista.jtxtUbicacion.getText();
            String tipo = (String) vista.jcboTipo.getSelectedItem();

            Almacen nuevoAlmacen = AlmacenFactory.crearAlmacen(tipo, nombre, ubicacion);
            boolean exito = dao.insertarAlmacen(nuevoAlmacen);

            if (exito) {
                JOptionPane.showMessageDialog(vista, "Almacén creado correctamente.");
            } else {
                JOptionPane.showMessageDialog(vista, "Error al crear el almacén.");
            }
        }
    }
}
