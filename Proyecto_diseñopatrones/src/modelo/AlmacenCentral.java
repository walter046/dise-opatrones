package modelo;

public class AlmacenCentral extends Almacen {
    public AlmacenCentral(String nombre, String ubicacion) {
        super(nombre, ubicacion);
    }

    @Override
    public String getTipo() {
        return "CENTRAL";
    }
}
