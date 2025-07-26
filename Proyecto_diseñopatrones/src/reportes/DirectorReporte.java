package reportes;

import javax.swing.table.DefaultTableModel;

public class DirectorReporte {
    private ReporteBuilder builder;

    public void setBuilder(ReporteBuilder builder) {
        this.builder = builder;
    }

    public DefaultTableModel construirReporte() {
        builder.construirEncabezado();
        builder.construirContenido();
        return builder.obtenerReporte();
    }
}
