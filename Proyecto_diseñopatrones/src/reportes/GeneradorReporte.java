package reportes;

import javax.swing.table.DefaultTableModel;

public class GeneradorReporte {

    public static DefaultTableModel generarReporteProductos() {
        DirectorReporte director = new DirectorReporte();
        ReporteBuilder builder = new ReporteProductosBuilder();
        director.setBuilder(builder);
        return director.construirReporte();
    }

    // Puedes agregar otros métodos para otros tipos de reporte
}
