import controlador.AlmacenControlador;
import conexion.ConexionBD;
import vista.AlmacenForm;

public class TestAlmacen {
    public static void main(String[] args) {
        AlmacenForm form = new AlmacenForm();
        AlmacenControlador controlador = new AlmacenControlador(form, ConexionBD.getInstancia().getConexion());
    }
}
