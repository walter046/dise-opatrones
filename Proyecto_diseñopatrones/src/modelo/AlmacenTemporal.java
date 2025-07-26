package modelo;

public class AlmacenTemporal extends Almacen {
    public AlmacenTemporal(String nombre, String ubicacion) {
        super(nombre, ubicacion);
    }

    @Override
    public String getTipo() {
        return "TEMPORAL";
    }
}
