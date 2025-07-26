import vista.InventarioForm;
import controlador.InventarioControlador;

public class Main {
    public static void main(String[] args) {
        InventarioForm form = new InventarioForm();
        new InventarioControlador(form);
        form.setVisible(true); // ← Esta línea es la que faltaba
    }
}
