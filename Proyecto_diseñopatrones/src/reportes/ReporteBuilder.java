package reportes;

import javax.swing.table.DefaultTableModel;

public interface ReporteBuilder {
    void construirEncabezado();
    void construirContenido();
    DefaultTableModel obtenerReporte();
}
