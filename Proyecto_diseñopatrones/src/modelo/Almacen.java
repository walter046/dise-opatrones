package modelo;

public abstract class Almacen {
    protected String nombre;
    protected String ubicacion;

    public Almacen(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public abstract String getTipo();

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
