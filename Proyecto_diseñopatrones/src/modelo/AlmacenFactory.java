package modelo;

public class AlmacenFactory {
    public static Almacen crearAlmacen(String tipo, String nombre, String ubicacion) {
        return switch (tipo) {
            case "CENTRAL" -> new AlmacenCentral(nombre, ubicacion);
            case "REGIONAL" -> new AlmacenRegional(nombre, ubicacion);
            case "TEMPORAL" -> new AlmacenTemporal(nombre, ubicacion);
            default -> throw new IllegalArgumentException("Tipo de almacén inválido.");
        };
    }
}
