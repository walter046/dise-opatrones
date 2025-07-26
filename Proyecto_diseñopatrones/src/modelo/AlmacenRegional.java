package modelo;

public class AlmacenRegional extends Almacen {
    public AlmacenRegional(String nombre, String ubicacion) {
        super(nombre, ubicacion);
    }

    @Override
    public String getTipo() {
        return "REGIONAL";
    }
}
